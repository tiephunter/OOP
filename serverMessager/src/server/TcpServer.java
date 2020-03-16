/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.Socket;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;


/**
 *
 * @author cmtie
 */
public class TcpServer {


    private static ServerSocket myServer = null;

    private static Connection conn = null;
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Messenger;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";
    public static HashMap<Integer,Socket> clientHashMap = null;

    public static void connectToDB(String dbURL, String userName, String password) {
        System.out.println("getConnection");
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //mo server Socket
    public static void openServer() {
        try {
            myServer = new ServerSocket(1233);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //wait connect va chuyen connect
    public static void startServer(int port) {
        try {
            while (true) {
                HandleConnection();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //xu ly connection
    public static void HandleConnection() {
        try {

            Socket clientSocket = myServer.accept();
            System.out.println("client be accepted !");
            HandleClientThread clientthread = new HandleClientThread(conn, clientSocket);
            clientthread.start();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        connectToDB(DB_URL, USER_NAME, PASSWORD);
        clientHashMap = new HashMap();
        openServer();
        startServer(1234);
    }
}

//handle thread de lay cac bien dung chung
class HandleClientThread extends Thread {

    Connection conn;
    Socket clientSocket;
//    HashMap<Integer, Socket> clientHashMap;

    DataInputStream in;
    DataOutputStream out;

    final static int SIGN_UP_ACTION = 1;
    final static int LOGIN_ACTION = 2;
    final static int LOGIN_SUCCESS = 3;
    final static int LOGIN_FALSE = 4;
    final static int LOAD_USER_lIST_ACTION = 5;
    final static int ADD_FRIEND_ACTION = 6;
    final static int ADD_FRIEND_SUCCESS = 8;
    final static int ADD_FRIEND_FAIL = 9;
    final static int LOAD_FRIEND_LIST_ACTION = 7;
    final static int CHAT_ACTION = 10;
    final static int CHAT_ACTION_SUCCESS = 11;
    final static int CHAT_ACTION_FAIL = 12;
    final static int SEND_MESSAGE_ACTION = 13;
    final static int RECEIVED_MESSAGE_ACTION = 14;
    final static int RECEIVED_MESSENGER_NOW = 15;
    final static int RECEIVED_MESSENGER_LATER = 16;

    private static String TenTaiKhoan = null;
    private static String MatKhau = null;
    private static String HoTen = null;
    private static String NgaySinh = null;
    private static int GioiTinh;
    private static String DiaChi = null;
    private static String QueQuan = null;
    private static String Email = null;

    public HandleClientThread(Connection conn, Socket clientSocket) {
        this.conn = conn;
        this.clientSocket = clientSocket;
//        this.clientHashMap = clientHashMap;
    }

    public static boolean testEmty() {
        if (TenTaiKhoan.equals("") || MatKhau.equals("") || HoTen.equals("") || NgaySinh.equals("") || DiaChi.equals("") || QueQuan.equals("") || Email.equals("")) {
            return true;
        }
        return false;
    }

    public void handleSignUp() throws Exception {
        TenTaiKhoan = in.readUTF();
        MatKhau = in.readUTF();
        HoTen = in.readUTF();
        NgaySinh = in.readUTF();
        GioiTinh = in.readInt();
        DiaChi = in.readUTF();
        QueQuan = in.readUTF();
        Email = in.readUTF();
        System.out.println(TenTaiKhoan);
        System.out.println(MatKhau);
        System.out.println(HoTen);
        System.out.println(NgaySinh);
        System.out.println(GioiTinh);
        System.out.println(DiaChi);
        System.out.println(QueQuan);
        System.out.println(Email);
        // crate statement
        if (testEmty() == true) {
            out.writeInt(SIGN_UP_ACTION);
            out.writeUTF("Bạn chưa nhập đầy đủ thông tin !!!");
            out.flush();
            return;
        } else {
            Statement stmt = conn.createStatement();
            // insert data to table
            stmt.execute("INSERT INTO Users(HoTen,NgaySinh,GioiTinh,DiaChi,QueQuan,Email,TenTaiKhoan,MatKhau)"
                    + " values(N'" + HoTen + "',N'" + NgaySinh + "'," + GioiTinh + ",N'" + DiaChi + "',N'" + QueQuan + "',N'" + Email + "',N'" + TenTaiKhoan + "',N'" + MatKhau + "')");
            out.writeInt(SIGN_UP_ACTION);
            out.writeUTF("Đăng Kí Thàng Công");
            out.flush();
        }
    }

    public void handleLogin() throws Exception {
        TenTaiKhoan = in.readUTF();
        MatKhau = in.readUTF();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select *\n"
                + "from Users\n"
                + "where TenTaiKhoan = N'" + TenTaiKhoan + "' and MatKhau = N'" + MatKhau + "'");
        System.out.println("Login by" + TenTaiKhoan);
        if (rs.next()) {
            System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7) + "  " + rs.getString(8) + "  " + rs.getString(9));
            out.writeInt(LOGIN_ACTION);
            out.writeInt(LOGIN_SUCCESS);
            out.writeInt(rs.getInt(1));
            out.writeUTF(rs.getString(2));
            out.writeUTF(rs.getString(3));
            out.writeInt(rs.getInt(4));
            out.writeUTF(rs.getString(5));
            out.writeUTF(rs.getString(6));
            out.writeUTF(rs.getString(7));
            out.writeUTF(rs.getString(8));
            out.writeUTF(rs.getString(9));
            out.flush();
            TcpServer.clientHashMap.put(rs.getInt(1),clientSocket);
            System.out.println("HashMap"+TcpServer.clientHashMap);
        } else {
            out.writeInt(LOGIN_ACTION);
            out.writeInt(LOGIN_FALSE);
            out.flush();
        }
    }

    public void handleSearchUserList() throws Exception {
        int idUser = in.readInt();
        String tfSearch = in.readUTF();

        Statement stmtSearch = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

//        Statement stmtAmount = conn.createStatement();
        ResultSet rsSearch = stmtSearch.executeQuery("SELECT Users.IdUser, Users.TenTaiKhoan \n"
                + " from Users \n"
                + " where TenTaiKhoan like N'" + tfSearch + "%'  "
                +" except "
                +" select Users.IdUser, Users.TenTaiKhoan \n"
                +" from FriendShip, Users\n"
                + " where\n"
                + " FriendShip.UserId = " + idUser +" \n"
                + " and FriendShip.FriendId = Users.IdUser ");



        rsSearch.last();
        out.writeInt(LOAD_USER_lIST_ACTION);
        out.writeInt(rsSearch.getRow());
        rsSearch.beforeFirst();
        while (rsSearch.next()) {
            System.out.println(rsSearch.getInt(1) + " " + rsSearch.getString(2) );
            out.writeInt(rsSearch.getInt(1));
            out.writeUTF(rsSearch.getString(2));
        }
        out.flush();
    }

    public void handleAddFriend() throws Exception {
        int idUser = in.readInt();
        int idFriend = in.readInt();

        Statement stmtCheckFriend = conn.createStatement();
        ResultSet rsCheckFriend =  stmtCheckFriend.executeQuery("select * \n" +
                                                                    "from FriendShip " +
                                                                    "where UserId = "+idUser+" and FriendId = "+idFriend );
        if(rsCheckFriend.next()){
            out.writeInt(ADD_FRIEND_ACTION);
            out.writeInt(ADD_FRIEND_FAIL);
            out.flush();
        }
        else{
            // insert into friendShip
            LocalTime TimeCreated = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
            Statement stmtAddFriend = conn.createStatement();
            stmtAddFriend.execute("INSERT INTO FriendShip(UserId,FriendId,TimeCreated)"
                    + "Values(" + idUser + "," + idFriend + ",'" + TimeCreated + "')");

            Statement stmtAddFriend1 = conn.createStatement();
            stmtAddFriend1.execute("INSERT INTO FriendShip(UserId,FriendId,TimeCreated)"
                    + "Values(" + idFriend + "," + idUser + ",'" + TimeCreated + "')");
            out.writeInt(ADD_FRIEND_ACTION);
            out.writeInt(ADD_FRIEND_SUCCESS);
            out.flush();
        }
    }

    public void handleLoadFriendList() throws Exception {
        int idUser = in.readInt();
        Statement stmtSearchNameFriend = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rsSearchNameFriend = stmtSearchNameFriend.executeQuery("select Users.IdUser, Users.TenTaiKhoan, Users.HoTen \n"
                + "from FriendShip, Users\n"
                + " where\n"
                + "FriendShip.UserId = " + idUser + "\n"
                + "and FriendShip.FriendId = Users.IdUser" );

        rsSearchNameFriend.last();
        rsSearchNameFriend.getRow();
        out.writeInt(LOAD_FRIEND_LIST_ACTION);
        out.writeInt(rsSearchNameFriend.getRow());
        System.out.println("Number of Friend " + rsSearchNameFriend.getRow());
        rsSearchNameFriend.beforeFirst();
//                            ArrayList<Friends> friendList = new ArrayList<>();
        while (rsSearchNameFriend.next()) {
//                                    Friends f = new Friends(rsSearchNameFriend.getInt(1),rsSearchNameFriend.getString(2),rsSearchNameFriend.getString(3));
//                                    friendList.add(f);
//                                
//                                out.writeInt(friendList.size());
            out.writeInt(rsSearchNameFriend.getInt(1));
            out.writeUTF(rsSearchNameFriend.getString(2));
            out.writeUTF(rsSearchNameFriend.getString(3));
        }
        out.flush();
    }

    public void handleChat () throws Exception{
        int idUser = in.readInt();
        int idFriend = in.readInt();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select *\n"
                                        + "from FriendShip\n"
                                        + "where UserId = "+idUser+" and FriendId = " +idFriend);
        if (rs.next()) {
            int sessionId = rs.getInt(4);
            if (sessionId == 0) {
                        //insert into Seesion
                LocalTime TimeStart = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
                LocalTime TimeFinish = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));

                PreparedStatement insertStmt = conn.prepareStatement("insert into "
                        + "Session(AmountUsers, TimeStart, TimeFinish) "
                        + "values( " + 2 + ", '" + TimeStart + "', '" + TimeFinish + "')",
                        Statement.RETURN_GENERATED_KEYS);
                insertStmt.execute();

                ResultSet insertRs = insertStmt.getGeneratedKeys();
                if (insertRs.next()) {
                    sessionId = insertRs.getInt(1);
                    stmt.execute("update FriendShip set sessionId = " + sessionId + " where UserId = " + idUser + " and FriendId = " + idFriend);
                    stmt.execute("update FriendShip set sessionId = " + sessionId + " where UserId = " + idFriend + " and FriendId = " + idUser);
                }
                out.writeInt(CHAT_ACTION);
                out.writeInt(CHAT_ACTION_SUCCESS);
                out.writeInt(idUser);
                out.writeInt(idFriend);
                out.writeInt(sessionId);
                out.writeInt(0);
                out.flush();
            } else {
                   out.writeInt(CHAT_ACTION);
                   out.writeInt(CHAT_ACTION_SUCCESS);
                   out.writeInt(idUser);
                   out.writeInt(idFriend);
                   out.writeInt(sessionId);
                   Statement loadMessageStmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   ResultSet loadMessageRs = loadMessageStmt.executeQuery("select * from Message where IdSession = " + sessionId);
                   loadMessageRs.last();
                   out.writeInt(loadMessageRs.getRow());
                   loadMessageRs.beforeFirst();
                   while (loadMessageRs.next()) {
                       out.writeInt(loadMessageRs.getInt(1));
                       out.writeUTF(loadMessageRs.getString(2));
            //                   out.writeFloat(loadMessageRs.getTime(4));
                       out.writeInt((loadMessageRs.getInt(5)));
                   }
                   out.flush();
            }
        }

    }

    public void handleReceivedMsg() throws Exception {
        int idSession = in.readInt();
        String tfInputMsg = in.readUTF();
        int idUser = in.readInt();
        int idFriend = in.readInt();

        //check idFriend in map or not
        boolean testIdFriend = TcpServer.clientHashMap.containsKey(idFriend);
        //
        LocalTime TimeStart = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        PreparedStatement stmt = conn.prepareStatement("insert into Message(TextMess,IdSession,Time,IdSender) "
                    + "values(N'"+tfInputMsg+"',"+idSession+",'"+TimeStart+"',"+idUser+")",Statement.RETURN_GENERATED_KEYS);

        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys();
        System.out.println("detect success 1");
        while(rs.next()){
            if(testIdFriend == true){
                System.out.println("detect success 2");
                Socket friendSocket = TcpServer.clientHashMap.get(idFriend);
                DataOutputStream friendOut = new DataOutputStream(friendSocket.getOutputStream());
                friendOut.writeInt(RECEIVED_MESSAGE_ACTION);
                friendOut.writeInt(RECEIVED_MESSENGER_NOW);
                friendOut.writeInt(rs.getInt(1));
                friendOut.writeInt(idSession);
                friendOut.writeInt(idUser);
                friendOut.writeUTF(tfInputMsg);
            }
            else{
                System.out.println("fail detect");
            }
        }

        out.flush();

    }

    public void run() {
        try {
            //takes input from client socket
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                //read messenge from client
                if (in.available() > 0) {
                    System.out.println("Got a package");

                    int action = in.readInt();

                    System.out.println("Action " + action);

                    switch (action) {
                        case SIGN_UP_ACTION:
                            System.out.println("go to singup action");
                            handleSignUp();
                            break;
                        case LOGIN_ACTION:
                            System.out.println("go to login action");
                            handleLogin();
                            break;

                        case LOAD_USER_lIST_ACTION:
                            System.out.println("go to search user action");
                            handleSearchUserList();
                            break;

                        case ADD_FRIEND_ACTION:
                            System.out.println("go to add friend action");
                            handleAddFriend();
                            break;

                        case LOAD_FRIEND_LIST_ACTION:
                            System.out.println("go to load Friends List Action");
                            handleLoadFriendList();
                            break;

                        case CHAT_ACTION :
                            System.out.println("go to chat Action");
                            handleChat();
                            break;

                        case SEND_MESSAGE_ACTION:
                            System.out.println("go to recived Message Action");
                            handleReceivedMsg();
                            break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
