#include <stdio.h>
#include <stdlib.h>

void chuyenCoSo2(int x)
{
    int coSo[50];
    int i=0;
    while(x!=0)
    {
        coSo[i]=x%2;
        i++;
        x=x/2;
    }
    int j;
    for(j=i-1;j>=0;j--)
    {
        printf("%d",coSo[j]);
    }
    printf("\n");

}
void chuyenCoSo8(int x){

    int coSo[50];
    int i=0;
    while(x!=0)
    {
        coSo[i]=x%8;
        i++;
        x=x/8;
    }
    int j;
    for(j=i-1;j>=0;j--)
    {
        printf("%d",coSo[j]);
    }
    printf("\n");}

menu(){
    int x;
    int chon=0;
    do{
            printf("----------MENU--------\n");
        printf("chon 1: Nhap he so 10\n");
        printf("chon 2: Chuyen sang co so 2\n");
        printf("chon 3: Chuyen sang co so 8\n");
        printf("chon 4: Ket Thuc\n");
        scanf("%d",&chon);
        switch(chon)
        {
            case 1: scanf("%d",&x);
            break;
            case 2: chuyenCoSo2(x);
            break;
            case 3: chuyenCoSo8(x);
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
