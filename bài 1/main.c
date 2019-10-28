#include <stdio.h>
#include <stdlib.h>
#define Max 50
#include <string.h>
typedef struct SinhVien{
    char HoTen[Max];
    int Tuoi;
    char Lop[Max];
}SinhVien;
void NhapDanhSach(SinhVien DanhSach[],int *soLuong)
{
    char x;
    printf("Nhap so luong sinh vien ");
    scanf("%d%c",soLuong,&x);//123 enter
    int i;
    for(i=0;i<*soLuong;i++)
    {
        printf("Nhap sinh vien thu %d\n",i+1);
        printf("Ho va ten: ");
        gets(DanhSach[i].HoTen);
        printf("Tuoi: ");
        scanf("%d%c",&DanhSach[i].Tuoi,&x);
        printf("Lop: ");
        gets(DanhSach[i].Lop);
    }

}
void HienThi(SinhVien DanhSach[],int soLuong)
{
    printf("%-20s||%-10s||%-10s||\n","Ho va Ten","Tuoi","Lop");
    int i;
    for(i=0;i<soLuong;i++)
    {
        printf("%-20s||%-10d||%-10s||\n",DanhSach[i].HoTen,DanhSach[i].Tuoi,DanhSach[i].Lop);
    }
}
void TimKiem(SinhVien DanhSach[],int soLuong)
{
    int i;
    printf("Nhap ten sinh vien can tim: ");
    char name[50];
    gets(name);
    for(i=0;i<soLuong;i++)
    {
        if(strcmp(DanhSach[i].HoTen,name)==0)
        {
            printf("Thong tin sinh vien can tim: \n");
            printf("%-20s||%-10s||%-10s||\n","Ho va Ten","Tuoi","Lop");
            printf("%-20s||%-10d||%-10s||\n",DanhSach[i].HoTen,DanhSach[i].Tuoi,DanhSach[i].Lop);
            return ;
        }
    }
}
void menu()
{
    int chon=0;
    char x;
    SinhVien DanhSach[Max];
    int soLuong=0;
    do{
        printf("1.	Chon 1 de Nhap danh sach sinh vien\n");
        printf("2.	Chon 2 de Hien thi danh sach sinh vien\n");
        printf("3.	Chon 3 de Tim kiem sinh vien theo ten()\n");
        printf("4.	Chon 4 de Ket thuc\n");
        printf("	Moi ban chon: ");
        scanf("%d%c",&chon,&x);
        switch(chon)
        {
            case 1: NhapDanhSach(DanhSach,&soLuong);
                    break;
            case 2: HienThi(DanhSach,soLuong);
                    break;
            case 3: TimKiem(DanhSach,soLuong);
                    break;
        }
    }while(chon != 4);
}
int main()
{
    menu();
    return 0;
}
