#include <stdio.h>
#include <stdlib.h>
void nhapDaySo(int a[],int *soluong){
    int i;
    printf("Nhap so luong phan tu ");
    scanf("%d",soluong);
    for(i=0;i<*soluong;i++){
        printf("Nhap vao so thu %d: ",i+1);
        scanf("%d",&a[i]);
    }
}
int timMax(int a[], int soluong, int max){
    if(soluong==0)
        return max;
    else if(max<a[soluong-1]){
        max=a[soluong-1];
    return timMax(a,soluong-1,max);
    }
    else
        return timMax(a,soluong-1,max);
}
int timTong(int a[],int soluong,int tong){
    if(soluong==0)
        return tong;
    else{
        tong+=a[soluong-1];
        return timTong(a,soluong-1,tong);
    }
}
menu(){
    int chon=0;
    int max;
    int a[50],soluong=0;
    int tong;
    char x;
    do{
        printf("---MENU-----\n");
        printf("chon 1: Nhap so nguyen duong\n");
        printf("chon 2: Tim so lon nhat\n");
        printf("chon 3: Tim tong cac day so\n");
        printf("chon 4 : Ket thuc\n");
        scanf("%d%c",&chon,&x);
        switch(chon){
        case 1:nhapDaySo(a,&soluong);
        break;
        case 2:printf("So nhat la %d",timMax(a,soluong,max=a[0]));
        break;
        case 3:printf("tong cac chu so la %d",timTong(a,soluong,tong=0));
        break;
        }
    }
    while(chon!=4);

}
int main()
{
    menu();
    return 0;
}
