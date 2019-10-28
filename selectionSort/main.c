#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[100],i,n,j;
    int min,swap;
    printf("Nhap so phan tu cua day so ");
    scanf("%d",&n);
    for(i=0;i<n;i++){
        printf("nhap phan tu thu a[%d]",i+1);
        scanf("%d",&a[i]);
        }
    for(i=0;i<(n-1);i++){
        min=i;
        for(j=i+1;j<n;j++)
        {
            if(a[min]>a[j])
                min=j;
        }
        if(min!=i)
        {
            swap = a[i];
            a[i] = a[min];
            a[min] = swap;
        }
    }
    printf("day moi dc sap xep la\n");
    for(i=0;i<n;i++)
    printf("%d\n", a[i]);
    return 0;
}
