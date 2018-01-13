#include<stdio>
#include<stdlib>
#include<conio>
using namespace std;
int main()
{
FILE *fpr,*fpw;
int read;
unsigned charb[1024];
//copy IO.SYS
fpr = fopen(“c:\\boot\\IO.SYS”,rb);
fpw = fopen(“I:\\IO.SYS”,”wb”);
while(1)
{ read =fread(b,1,1024,fpr);
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
                           //copy MSDOS.SYS
fpr = fopen(“c:\\boot\\ MSDOS.SYS”,rb);
fpw = fopen(“I:\\ MSDOS.SYS”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
                           //copy CONFIG.SYS
fpr = fopen(“c:\\boot\\ CONFIG.SYS”,rb);
fpw = fopen(“I:\\ CONFIG.SYS”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
                   //copy COMMAND.COM
fpr = fopen(“c:\\boot\\ COMMAND.COM”,rb);
fpw = fopen(“I:\\ COMMAND.COM”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);

                       //copy SYS.COM
fpr = fopen(“c:\\boot\\ SYS.COM”,rb);
fpw = fopen(“I:\\ SYS.COM”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
                          //copy EDIT.COM
fpr = fopen(“c:\\boot\\ EDIT.COM”,rb);
fpw = fopen(“I:\\ EDIT.COM”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
printf(“files copied successfully !!!! ”);

printf(“Now USB is bootable USB !!!! ”);
getch();
}
                       //copy FDISK.EXE
fpr = fopen(“c:\\boot\\ FDISK.EXE”,rb);
fpw = fopen(“I:\\ FDISK.EXE”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
printf(“files copied successfully !!!! ”);

printf(“Now USB is bootable USB !!!! ”);
getch();
}
                        //copy FORMAT.COM
fpr = fopen(“c:\\boot\\ FORMAT.COM”,rb);
fpw = fopen(“I:\\ FORMAT.COM”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
printf(“files copied successfully !!!! ”);

printf(“Now USB is bootable USB !!!! ”);
getch();

                  //copy HIMEN.SYS
fpr = fopen(“c:\\boot\\ HIMEN.SYS”,rb);
fpw = fopen(“I:\\ HIMEN.SYS”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
printf(“files copied successfully !!!! ”);

printf(“Now USB is bootable USB !!!! ”);
getch();
}
//copy MOUSE.COM
fpr = fopen(“c:\\boot\\ MOUSE.COM”,rb);
fpw = fopen(“I:\\ MOUSE.COM”,”wb”);
while(1)
{ read =fread( b , 1 , 1024 , fpr );
      if (read < 1)
    {   
         if (read == 0)
            break;
    }
  if(fwrite(b,read,1,fpw) !=1)
 break;
}
fclose(fpw);
fclose(fpr);
printf(“files copied successfully !!!! ”);

printf(“Now USB is bootable USB !!!! ”);

return 0;
}

