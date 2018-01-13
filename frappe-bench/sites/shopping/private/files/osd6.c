#include<stdio.h>
#include<stdlib.h>
int main()
{
int a,b,c,ch;
FILE *fp;
fp=fopen("/tmp/ramdisk/input.txt","r");
fscanf(fp,"%d",&a);
fscanf(fp,"%d",&b);
fclose(fp);
fp=fopen("/tmp/ramdisk/output.txt","w");
fprintf(fp,"\n Addtion: %d",(a+b));
fprintf(fp,"\n Substractiion: %d",(a-b));
fprintf(fp,"\n Multiplication: %d",(a*b));
fprintf(fp,"\n Division: %d",(a/b));
return 0;
}
