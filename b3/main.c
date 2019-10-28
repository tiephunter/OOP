#include <stdio.h>
#include <stdlib.h>
void NhapDaySo(int a[],int* soLuong)
{
    printf("Nhap so luong phan tu: ");
    scanf("%d",soLuong);
    int i;
    for(i=0;i<*soLuong;i++)
    {
        printf("Nhap phan tu thu %d: ",i+1);
        scanf("%d",&a[i]);
    }
}
int timMax(int a[],int soLuong,int max)
{
    if(soLuong == 0)
        return max;
    else if(max<a[soLuong-1])
    {
        max  = a[soLuong-1];
        return timMax(a,soLuong-1,max);
    }else
    return timMax(a,soLuong-1,max);
}
int tinhTong(int a[],int soLuong,int tong)
{
    if(soLuong == 0)
        return tong;
    else {
        tong += a[soLuong-1];
        return tinhTong(a,soLuong-1,tong);
    }
}
void menu()
{
    int chon=0;
    int a[50],soLuong=0,max,tong;
    char x;
    do{
        printf("1.	Chon 1 de Nhap so nguyen duong\n");
        printf("2.	Chon 2 de Tim phan tu lon nhat\n");
        printf("3.	Chon 3 de Tinh tong day so\n");
        printf("4.	Chon 4 de Ket thuc\n");
        printf("	Moi ban chon: ");
        scanf("%d%c",&chon,&x);
        switch(chon)
        {
            case 1: NhapDaySo(a,&soLuong);
                    break;
            case 2: printf("So lon nhat la %d\n",timMax(a,soLuong,max=a[0]));
                    break;
            case 3: printf("Tong la: %d\n",tinhTong(a,soLuong,tong=0));
                    break;
        }
    }while(chon != 4);
}
int main()
{
    menu();
    return 0;
}
