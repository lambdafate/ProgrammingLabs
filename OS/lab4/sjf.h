#ifndef SCHDULE_SJF_H
#define SCHDULE_SJF_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "job.h"

/*
    短作业优先(SJF)调度算法
    只有在多个作业可以同时运行的时候, SJF才是最优的
*/


//查找当前current_time未执行的最短作业,若无返回-1
//返回-1代表没有可执行作业, 可以结束
int findjob_sjf(job jobs[],int count, int current_time)
{
	int minjob=-1;//=jobs[i].need_time;
	int minloc=-1;

	
	//先在 当前就绪的进程里 查找最短作业
    if(current_time > 0){
        for(int i=0;i<count;i++)
        {
            if(minloc == -1){
                if(jobs[i].visited==0 && jobs[i].reach_time <= current_time){
                    minjob = jobs[i].need_time;
                    minloc = i;
                }
            }else if(jobs[i].visited==0 && jobs[i].reach_time<=current_time && jobs[i].need_time < minjob){
                minjob = jobs[i].need_time;
                minloc = i;
            }	
        }
    }


	if(minloc != -1){
		return minloc;
	}

	//在 未来最近到达的进程中 查找最短作业
	int reach_time = -1;
	for(int i=0;i<count;i++)
	{
		if(minloc==-1){
			if(jobs[i].visited==0){
			minjob=jobs[i].need_time;
			minloc=i;
			reach_time=jobs[i].reach_time;
			}
		}
		else if(jobs[i].visited==0 && jobs[i].reach_time <= reach_time && jobs[i].need_time < minjob)
		{
			minjob=jobs[i].need_time;
			minloc=i;
			reach_time=jobs[i].reach_time;
		}
	}
	return minloc;
}


//短作业优先作业调度
void SJF()
{
    int i; 
	int current_time=0;
	int loc;
	int total_waitime=0;
	int total_roundtime=0;

    loc = findjob_sjf(jobs, quantity, current_time);
    if(loc != -1){
        current_time = jobs[loc].reach_time;
    }
    //输出作业流
	printf("\n\nSJF算法作业流\n");
	printf("------------------------------------------------------------------------\n"); 
	printf("\tjobID\treachtime\tstarttime\twaittime\troundtime\n");

    while(loc != -1){
        //该作业存在等待时间
        if(current_time > jobs[loc].reach_time){
            jobs[loc].start_time = current_time;
            
        }else{
            current_time = jobs[loc].reach_time;
            jobs[loc].start_time = jobs[loc].reach_time;
        }
      
        //计算等待时间
        jobs[loc].wait_time = jobs[loc].start_time - jobs[loc].reach_time;
        total_waitime += jobs[loc].wait_time;
        total_roundtime = total_roundtime + jobs[loc].wait_time + jobs[loc].need_time;     

        //进程执行完毕
        jobs[loc].isreached = true;
        jobs[loc].visited = true;
        current_time = jobs[loc].start_time + jobs[loc].need_time;
     
        //输出该进程执行信息
        printf("\t%-8d\t%-8d\t%-8d\t%-8d\t%-8d\n",loc+1,jobs[loc].reach_time,jobs[loc].start_time,jobs[loc].wait_time,
        jobs[loc].wait_time+jobs[loc].need_time);

        //执行下一个进程
        loc = findjob_sjf(jobs, quantity, current_time);
    }

    printf("总等待时间:%-8d 总周转时间:%-8d\n",total_waitime,total_roundtime); 
	printf("平均等待时间: %4.2f 平均周转时间: %4.2f\n",(float)total_waitime/(quantity),(float)total_roundtime/(quantity)); 

}






#endif  


