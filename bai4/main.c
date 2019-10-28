#include <stdio.h>
#include <stdlib.h>o
#define MAX 50
void nhapMaTran(int a[][MAX], int *n)
{
    int i,j;
    printf("Nhap cap do ma tran ");
    scanf("%d",n);
    for(i=0;i<*n;i++)
    {
        for(j=0;j<*n;j++){
            printf("nhap phan tu thu a[%d][%d]",i+1,j+1);
            scanf("%d",&a[i][j]);
        }
    }
}
void inCheoChinh(int a[][MAX],int n){
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            if(i==j)
                printf("%3d",a[i][j]);
            else
                printf("%3c","*");
                printf("\n");
            }
        }
    }
menu(){
    int chon=0;
    int a[MAX][MAX];
    char x;
    int n;
    do{
        printf("--------MENU---------\n");
        printf("chon 1: Nhap danh sach ma tran\n");
        printf("chon 2: In ra duong cheo chinh\n");
        printf("chon 3: Ket thuc\n");
        scanf("%d%c",&chon,&x);
        switch(chon)
        {
            case 1: nhapMaTran(a,&n);
            break;
            case 2: inCheoChinh(a,n);
            break;
            default:system("cls");
        }
    }while(chon!=3);
}
int main()
{
    menu();
    return 0;
}
