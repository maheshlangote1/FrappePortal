#include<stdio.h>
#include<sys/shm.h>
#include<sys/ipc.h>
#include<string.h>
int main()
{
key_t key;
int shmid1,shmid2,shmid3;
int *d1,*d2;
char *data2;
int i,j,k,no,tens,ones,sqr,sq,onsqr;
char no1[10],fsq[20],sqr1[10],ons[2];
key=7668;
shmid1=shmget(key,1024,0644|IPC_CREAT);
//shmid2=shmget(key,1024,0644|IPC_CREAT);
//shmid3=shmget(key,1024,0644|IPC_CREAT);
d1=shmat(shmid1,(void*)0,0);
d2=shmat(shmid1,(void*)0,0)+4;
data2=shmat(shmid1,(void*)0,0)+8;
//printf("%d\n",*d1);
//printf("%d\n",*d2);
//printf("%c\n",*data2);
//return 0;
//memset(d1,0,1024);
//memset(d2,0,1024);
//memset(data2,0,1024);
//printf("%d",*data);
ones=*d1%10;
//printf("%d",ones);
sqr=ones*ones;
if((sqr/10)>0)
*d2=sqr/10;
//printf("%d",*data1);
onsqr=sqr%10;
sprintf(ons,"%d",onsqr);
strcpy(data2,ons);
if(shmdt(d1) != 0)
		fprintf(stderr, "Could not close memory segment.\n");
/*if(shmdt(data1) != 0)
		fprintf(stderr, "Could not close memory segment.\n");
if(shmdt(data2) != 0)
		fprintf(stderr, "Could not close memory segment.\n");
*/
return 0;
}
	
