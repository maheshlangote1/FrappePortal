/*
Experiment No.5 :  constructing a minimum cost spanning tree of a graph using Prim's algorithm.
*/

#define infinity 9999
#define MAX 20
#include<iostream>
#include<stdlib.h>
#include <time.h> 
#include<omp.h>
using namespace std;
class graph
{ int G[MAX][MAX];
  int n;
  public:
      graph()
	{ n=0; }
      void readgraph();
      void printgraph();
      int  prims(graph &);
};


void graph:: readgraph()
{
	int i,j,vi,vj,no_of_edges,weight;
	cout<<"\nEnter no. of vertices :";
	cin>>n;
	cout<<"\nEnter no of edges :";
	cin>>no_of_edges;
	int th= omp_get_thread_num();

	for(i=0;i<n;i++) //Initialize the adjacency matrix
		for(j=0;j<n;j++)
			G[i][j]=0;
	cout<<"\n Thread id:"<<th;
	cout<<"\nEnter the list of edges : ";

	for(i=0;i<no_of_edges;i++)
	{
		cout<<"\nEnter an edge (u,v,weight)  :";
		cin>>vi>>vj>>weight;
		G[vi][vj]=G[vj][vi]=weight;
	}
}

void  graph:: printgraph()
 {
	int i,j;
	cout<<"\nList of edges in the spanning tree: ";
	#pragma omp parallel for
		for(i=0;i<n-1;i++)//Scan the upper triangle of the adjacency matrix
		for(j=i+1;j<n;j++)
		    if(G[i][j]!=0)
			cout<<"\n(u,v,weight)= ("<<i<<","<<j<<","<<G[i][j]<<")";
			int th2=omp_get_thread_num();
			cout<<"\n thread id"<<th2;

 }

int  graph::prims(graph &spanning)
{
	int cost[MAX][MAX];
	int u,v,min_distance,distance[MAX],from[MAX];
	int visited[MAX],no_of_edges,i,min_cost,j;
//	create cost[][] matrix and empty spanning[][]
//	Matrix spanning is for storing of spanning tree
	int th1= omp_get_thread_num();
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			if(G[i][j]==0)
				cost[i][j]=infinity;
			else
				cost[i][j]=G[i][j];
		       spanning.G[i][j]=0;
			//cout<<"\n Thread id:"<<th1;
		}
//	initialise visited[],distance[] and from[]
	distance[0]=0;visited[0]=1;
	for(i=1;i<n;i++)
	  {
		distance[i]=cost[0][i];
		from[i]=0;
		visited[i]=0;
	  }
	min_cost=0;            //cost of spanning tree
	no_of_edges=n-1;       //no.of edges to be added
	while(no_of_edges>0)
	  {
		//find the vertex at minimum distance from the tree
		min_distance=infinity;
		for(i=1;i<n;i++)
			if(visited[i]==0 && distance[i] < min_distance)
			  {
				v=i;
				min_distance=distance[i];
			  }
		u=from[v];
		// insert the edge in spanning tree
		spanning.G[u][v]=distance[v];
		spanning.G[v][u]=distance[v];
		no_of_edges--;
		visited[v]=1;
		// update the distance[] array
//int start_s=clock();

	#pragma omp critical
		for(i=1;i<n;i++)
			if(visited[i]==0 && cost[i][v] < distance[i])
			   {
				distance[i]=cost[i][v];
				from[i]=v;
			   }
		min_cost=min_cost+cost[u][v];

	}
 	//int stop_s=clock();
	
	//cout << "\nExcution Time: " << stop_s-start_s << endl;
	spanning.n=n;
	return(min_cost);
}

int main()
{
	graph g1,spanning;
	int total_cost;
#pragma omp parallel num_threads(4)
{
#pragma omp sections
{
	#pragma omp section
	{
		g1.readgraph();
	//	int start_s=clock();

		 total_cost=g1.prims(spanning);
		//int stop_s=clock();
	}
}


	cout<<"\nspanning tree matrix : \n";

	spanning.printgraph();
	cout <<"\nTotal cost of spanning tree= "<<total_cost<<endl;
}
	

	//cout << "\nExcution Time: " << stop_s-start_s << endl;
	
	return 0;
}


/*

OUTPUT:

Enter no. of vertices :8

Enter no of edges :10

 Thread id:0
Enter the list of edges : 
Enter an edge (u,v,weight)  :0 1 2

Enter an edge (u,v,weight)  :0 2 1

Enter an edge (u,v,weight)  :1 3 4

Enter an edge (u,v,weight)  :1 4 2

Enter an edge (u,v,weight)  :2 5 2

Enter an edge (u,v,weight)  :2 6 3

Enter an edge (u,v,weight)  :3 7 4

Enter an edge (u,v,weight)  :4 7 3

Enter an edge (u,v,weight)  :5 7 6

Enter an edge (u,v,weight)  :6 7 2

spanning tree matrix : 

List of edges in the spanning tree: 
spanning tree matrix : 

List of edges in the spanning tree: 
(u,v,weight)= (0,1,2)
(u,v,weight)= (0,2,1)
(u,v,weight)= (1,3,4)
(u,v,weight)= (1,4,2)
(u,v,weight)= (2,5,2)
(u,v,weight)= (
spanning tree matrix : 

(u,v,weight)= (02,,6,13,)2)
(u,v,weight)= (6,7,2)
 thread id0
Total cost of spanning tree= 16

List of edges in the spanning tree: 
(u,v,weight)= (0,1,2)
(u,v,weight)= (0,2,1)
(u,v,weight)= (1,3,4)
(u,v,weight)= (1,4,2)
(u,v,weight)= (2,5,2)
(u,v,weight)= (2,6,3)
(u,v,weight)= (6,7,2)
 thread id2
Total cost of spanning tree= 16

(u,v,weight)= (0,2,1)
(u,v,weight)= (1,3,4)
(u,v,weight)= (1,4,2)
(u,v,weight)= (2,5,2)
(u,v,weight)= (2,6,3)
(u,v,weight)= (6,7,2)
 thread id1
Total cost of spanning tree= 16

spanning tree matrix : 

List of edges in the spanning tree: 
(u,v,weight)= (0,1,2)
(u,v,weight)= (0,2,1)
(u,v,weight)= (1,3,4)
(u,v,weight)= (1,4,2)
(u,v,weight)= (2,5,2)
(u,v,weight)= (2,6,3)
(u,v,weight)= (6,7,2)
 thread id3
Total cost of spanning tree= 16


*/
