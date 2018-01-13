// RUN THIS PGM IN RED HAT


#include<iostream>
#include<unistd.h>
#include<string.h>
#include<sys/types.h>  // mkfifo	
#include<sys/stat.h>   // mkfifo
#include<sys/wait.h>
using namespace std;
int main()
{
    char str[255]={0};    //string to be reversed.
    char res[255]={0};    //string after reversel.
    int fd[2];
    pipe(fd);
    pid_t pid;        //variable to store pid of child/parent
    pid=fork();        //fork system call to create a child process.
    
    
    
    //child process block.
    if(pid==0)
    {    
        close(fd[0]);            //close the unwanted pipe(as per the rule)
        cout<<"Enter the String: ";
        cin>>str;            //accept the string.
        write(fd[1],str,strlen(str));    //write to the pipe fd[1] which is the write pipe.
    }    
    //parent process block.
    else if(pid>0)
    {
        waitpid(pid,0,0);        //wait for the child to complete.
        close(fd[1]);            //close the unwanted write pipe.
        int len=(read(fd[0],res,255));    //reversing the string.
        len--;
        cout<<"\nThe reversed string: ";
        for(int i=len;i>=0;i--)
        {        
            cout<<res[i];        
        }
        cout<<endl;
        
    }
    //failure block.
    else
    {
        cout<<"Could not fork\n";
    }
    return 0;
}

