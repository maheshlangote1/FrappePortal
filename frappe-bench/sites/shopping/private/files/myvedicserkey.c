#include<stdio.h>
#include<sys/shm.h>
#include<sys/ipc.h>
#include<string.h>
int main()
{

key_t key;
int shmid1,shmid2,shmid3;
int *data,*data1;
char *data2;
int i,j,k,no,tens,ones,sqr,sq;
char no1[10],fsq[20],sqr1[10];
key=7668;
//key1=7669;
//key2=7670;

shmid1=shmget(key,1024,0644|IPC_CREAT);
//shmid2=shmget(key1,1024,0644|IPC_CREAT);
//shmid3=shmget(key2,1024,0644|IPC_CREAT);
data=shmat(shmid1,(void*)0,0);
data1=shmat(shmid1,(void*)0,0)+4;
data2=shmat(shmid1,(void*)0,0)+8;
memset(data,0,1024);
//memset(data1,0,1024);
//memset(data2,0,1024);
printf("Enter any no:");
scanf("%d",&no);
*data=no;
tens=no/10;
//*data1=10;
//*data2='a';
//return 0;
//while(*data1==0);
//printf("now executed client:%d\n",*data1);
sleep(10);
	if(*data1>0)
	{
 	sq=(tens*(no+(*data%10)))+(*data1);
	sprintf(fsq,"%d",sq);
	for(i=0;i<strlen(fsq);i++);
	fsq[i]=*data2;
	i++;
	fsq[i]='\0';
	}
	else
{		sq=(tens*(no+(*data%10)));
	sprintf(fsq,"%d",sq);
	for(i=0;i<strlen(fsq);i++);
	fsq[i]=*data2;
	i++;
	fsq[i]='\0';
}
 __fpurge(stdin);
printf("%s\n",fsq);
/*for(i=0;i<strlen(fsq);i++)
printf("%c",fsq[i]);
printf("\n");*/
	if(shmdt(data) != 0)
		fprintf(stderr, "Could not close memory segment.\n");
/*if(shmdt(data1) != 0)
		fprintf(stderr, "Could not close memory segment.\n");
if(shmdt(data2) != 0)
		fprintf(stderr, "Could not close memory segment.\n");
*/
    return 0;
}

