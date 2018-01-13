#include<stdio.h>
#include<cuda.h>

__global__ void mul_matrices(float *ad,float *bd,float *cd,int N)
{
        //cd[threadIdx.y * N + threadIdx.x] = ad[threadIdx.y * N + threadIdx.x] - bd[threadIdx.y * N + threadIdx.x];

        int pvalue=0;

        //find Row and Column corresponding to a data element for each thread
        int Row = blockIdx.y * blockDim.y + threadIdx.y;
        int Col = blockIdx.x * blockDim.x + threadIdx.x;

        //calculate dot product of Row of First Matrix and Column of Second Matrix
        for(int i=0;i< N;++i)
        {
                int m=ad[Row * N+i];
                int n=bd[i * N + Col];
                pvalue += m * n;
        }

        //store dot product at corresponding positon in resultant Matrix
        cd[Row * N + Col] = pvalue;

}
int main()
{
	int N = 4;				//size of square matrix
    unsigned int i,j;

	float *a,*b;
	float *ad,*bd,*cd,*c;
	size_t size=sizeof(float)* N * N;

    //allocate memory on host
	a=(float*)malloc(size);
	b=(float*)malloc(size);
    c=(float*)malloc(size);

    //allocate memory on device
	cudaMalloc(&ad,size);
	//printf("\nAfter cudaMalloc for ad\n%s\n",cudaGetErrorString(cudaGetLastError()));
	cudaMalloc(&bd,size);
	//printf("\nAfter cudaMalloc for bd\n%s\n",cudaGetErrorString(cudaGetLastError()));
    cudaMalloc(&cd,size);
	//printf("\nAfter cudaMalloc for cd\n%s\n",cudaGetErrorString(cudaGetLastError()));

    //initialize host memory with its own indices
    for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
        {
			a[i * N + j]=(float)(i * N + j);
            b[i * N + j]= -(float)(i * N + j);
        }
    }

	//copy data from host memory to device memory
	cudaMemcpy(ad,a,size,cudaMemcpyHostToDevice);
    //printf("\nAfter HostToDevice Memcpy for ad\n%s\n",cudaGetErrorString(cudaGetLastError()));
	cudaMemcpy(bd,b,size,cudaMemcpyHostToDevice);
    //printf("\nAfter HostToDevice Memcpy for bd\n%s\n",cudaGetErrorString(cudaGetLastError()));

	//calculate execution configuration
    //dim3 blocksize (N, N);		//each block contains N * N threads, each thread calculates 1 data element

    //GPU timer code
    float time;
    cudaEvent_t start,stop;
	cudaEventCreate(&start);
    cudaEventCreate(&stop);
	cudaEventRecord(start,0);

    dim3 blocksize(2,2);		        //each block contains 16 * 16 (=256) threads
	dim3 gridsize(N/2,N/2);			//creating just sufficient no of blocks


    mul_matrices<<< gridsize, blocksize >>>(ad, bd, cd, N);

    cudaEventRecord(stop,0);
	cudaEventSynchronize(stop);
	cudaEventElapsedTime(&time,start,stop);			//time taken in kernel call calculated
	cudaEventDestroy(start);
	cudaEventDestroy(stop);

	cudaMemcpy(c,cd,size,cudaMemcpyDeviceToHost);
	//printf("\nAfter DeviceToHost Memcpy for c \n%s\n",cudaGetErrorString(cudaGetLastError()));

	printf("Matrix A was---\n");
	for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
			printf("%f ",a[i*N+j]);
		printf("\n");
	}
	printf("\nMatrix B was---\n");
	for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
			printf("%f ",b[i*N+j]);
		printf("\n");
	}
	printf("\nAddition of A and B gives C----\n");
	for(i=0;i<N;i++)
	{
		for(j=0;j<N;j++)
			printf("%f ",c[i*N+j]);              //if correctly evaluated, all values will be 0
		printf("\n");
	}

	printf("\n\nTime taken is %f (ms)\n",time);

    //deallocate host and device memories
    cudaFree(ad); cudaFree(bd); cudaFree (cd);
	free(a);free(b);free(c);

	//_getch();
    return 1;
}
