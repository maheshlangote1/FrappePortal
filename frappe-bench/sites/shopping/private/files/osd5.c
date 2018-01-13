#include<stdio.h>
#include<stdlib.h>
int main(void)
{
printf("\n We are creating RAMDISK with 256M size");
system("rmdir/tmp/ramdisk");
system("mkdir/tmp/ramdisk");
system("Dir created successfully....");
system("chmod 777 /tmp/ramdisk");
system("mount -t tmpfs -o size=256M tmpfs /tmp/ramdisk");
printf("\nRAMDISK IS CREATED AND MOUNTED To/TMP/RAMDISK/FLODER ");
system("df -h| grep ram");
system("cp input.txt/tmp/ramdisk");
system("cp calculator/tmp/ramdisk");
return 0;
}
