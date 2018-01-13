#include<iostream>
#include<sys/stat.h>
#include<stdlib.h>
using namespace std;

int main()
{
system("hostname");				
char fname[255];
cout<<"Enter absolute path for your file:";                 //eg: /home/student/g1.cpp
cin>>fname;
struct stat var;                            
int ret=stat(fname,&var);

if(ret<0)
{
cout<<"System call stat exited with an error code "<<ret<<endl;
}
else
{
cout<<"Device id: "<<var.st_dev<<endl;
cout<<"Inode number:"<<var.st_ino<<endl;
cout<<"Mode: "<<var.st_mode<<endl;
cout<<"UID: "<<var.st_uid<<endl;
cout<<"GID: "<<var.st_gid<<endl;
cout<<"Size: "<<var.st_size<<endl;
}

struct stat
{
dev_t     st_dev;           /* ID of device containing file */
ino_t     st_ino;          /* inode number */
mode_t    st_mode;         /* protection */
nlink_t   st_nlink;       /* number of hard links */
uid_t     st_uid;        /* user ID of owner */
gid_t     st_gid;        /* group ID of owner */
off_t     st_size;       /* total size, in bytes */
blksize_t st_blksize;    /* blocksize for filesystem I/O */
blkcnt_t  st_blocks;    /* number of 512B blocks allocated */
};                                                                        

}

