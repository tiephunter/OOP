#include <stdio.h>
#include <stdlib.h>

void chuyenCoSo2(int x)
{
    int coSo[50];
    int i;
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
void chuyenCoSo8(int x){}

menu(){
    int x;
    chon=0;
    do{
            printf("----------MENU--------");
        printf("chon 1: Nhap he so 10");
        printf("chon 2: Chuyen sang co so 2");
        printf("chon 3: Chuyen sang co so 8");
        printf("chon 4: Ket Thuc");
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
    while(chon!=4)

}

int main()
{
    printf("Hello world!\n");
    return 0;
}
