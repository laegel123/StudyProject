
### Docker 문법
- \# : comment
- FROM : 컨테이너의 BASE IMAGE (운영환경)
- MAINTAINER : 이미지를 생성한 사람의 이름 및 정보
- LABEL : 컨테이너 이미지에 컨테이너의 정보를 저장      
        
- RUN : 컨테이너 빌드를 위해 base image 에서 실행할 commands
- COPY : 컨테이너 빌드 시 호스트의 파일을 컨테이너로 복사
- ADD : 컨테이너 빌드 시 호스트의 파일 (tar, url 포함) 을 컨테이너로 복사
- WORKDIR : 컨테이너 빌드 시 명령이 실행될 작업 디렉토리 설정
- ENV : 환경변수 지정
- USER : 명령 및 컨테이너 실행 시 적용할 유저 설정       
  
- VOLUME : 파일 또는 디렉토리를 컨테이너의 디렉토리로 마운트
- EXPOSE : 컨테이너 동작 시 외부에서 사용할 포트 지정
- CMD : 컨테이너 동작 시 자동으로 실행할 서비스나 스크립트 지정
- ENTRYPOINT : CMD 와 함께 사용하면서 command 지정 시 사용

-> CMD 와 ENTRYPOINT 가 함께 쓰이는 경우에는 ENTRYPOINT 가 명령어, CMD 가 argument 나 option 등에 쓰인다.



---

- 실행중인 컨테이너 목록 확인 
> docker ps [옵션]

- foreground로 실행중인 컨테이너에 연결
> docker attach [옵션] 컨테이너이름

- 동작중인 컨테이너에 NEW 명령어 추가 실행
> docker exec -it webserver /bin/bash

- 컨테이너에서 동작되는 프로세스 확인
> docker top [옵션] 컨테이너이름

- 동작중인 컨테이너가 생성한 로그 보기
> docker logs [옵션] 컨테이너이름
> docker logs -f 컨테이너 이름 => 실시간으로 로그 업데이트 보여줌

- 실행중인 컨테이너 정보를 확인할 때
> docker inspect [옵션] 컨테이너 이름
> ex) docker inspect --format '{{.NetworkSettings.IPAddress}}' webserver


---

컨테이너 관리법

## 하드웨어 리소스 제한
기본적으로 컨테이너는 호스트 하드웨어 리소스의 사용 제한을 받지 않는다.

### docker command 를 통해 제한할 수 있는 리소스
- CPU
- Memory
- Disk I/O

docker run --help 참고


### Memory 리소스 제한
- --memory, -m : 컨테이너가 사용할 최대 메모리의 양을 지정.
- --memory-swap : 컨테이너가 사용할 스왑 메모리 영역에 대한 설정. 메모리+스왑. 생략 시 메모리의 2배가 설정 됨.
- --memory-reservation : --memory 값보다 적은 값으로 구성하는 소프트 제한 값 설정.
- --oom-kill-disable : OOM Killer 가 프로세스 Kill 하지 못하도록 보

### CPU 리소스 제한
- --cpus : 컨테이너에 할당할 CPU core수를 지정.
- --cpuset-cpus : 컨테이너가 사용할 수 있는 CPU나 코어를 할당. cpu index 는 0부터. (ex. --cpuset-cpus=0-4)
- --cpu-share : 컨테이너가 사용하는 CPU 비중을 1024 값을 기반으로 설정. --cpu-share 2048 -> 기본 값보다 두 배 많은 COU 자원을 할당.

### Block I/0 제한
- --blkio-weight, --blkio-weight-device : Block IO 의 Quota 를 설정할 수 있으며 100~1000까지 선택. default 500
- --device-read-bps, --device-write-bps : 특정 디바이스에 대한 읽기와 쓰기 작업의 초당 제한을 kb, mb, gb 단위로 설정.
- --device-read-iops, --device-write-iops : 컨테이너의 read/write 속도의 쿼터를 설정한다. 초당 quota 를 제한해서 I/O 를 발생시킴. 0 이상의 정수로 표기.

## 사용 리소스 모니터링 방법
- docker monitoring commands
- docker stat : 실행중인 컨테이너의 런타임 통계를 확인.
- docker events : 도커 호스트의 실시한 event 정보를 수집해서 출력.
- cAdvisor : 구글에서 만든 도커 모니터링 툴.

---

## 컨테이너 볼륨
본래 이미지는 readonly 이다. 그러나 컨테이너화 되면서 readwrite 레이어가 추가되며 하나의 프로세스 안에서 동작하는 것 처럼 보이게 한다. -> Union File System, Overlay 라고 함.


## 데이터 보존
데이터 보존을 위해서 docker host 에 추가로 공간을 할당해 rw 레이어에 추가되는 데이터를 저장되게 한다.
-v <host path>:<container mount path>

ex)
docker run -d --name db
-v /dbdata:/var/lib/mysql
-e MYSQL_ALLOW_EMPTY_PASSWORD=pass
mysql:lates

rw(/var/lib/mysql)에 저장되는 데이터를 Docker HOST 디스크에 할당한 /dbdata 에 저장되게 한다.
또는 -v /var/lib/mysql 만 적으면 도커 폴더 안에 /UUID/임시폴더 아래에 자동 저장되게 한다.
=> VOLUME MOUNT 라고 한다.
But, 이 경우 컨테이너가 docker host 의 파일을 변경할 수 있는 문제점이 생김.
따라서 다음과 같은 옵션을 추가할 수 있음.
-v /dbdata:/var/www/html:ro


## 컨테이너 간 데이터 공유
docker run -v /webdata:/webdata -d --name df laegel/df:latest
docker run -d -v /webdata:/usr/sshare/nginx/html:ro -d ubuntu:latest

---

# 도커 네트워크
1. 컨테이너는 어떻게 통신하는가 ?
2. 컨테이너 포트를 외부로 노출할 수 있는가 ?
3. 컨테이너 네트워크를 추가할 수 있는가 ?
4. 컨테이너끼리 통신은 어떻게 하는가 ?

## 1
docker daemon 이 실행되면 docker0 라는 도커 네트워크 인터페이스가 생김.
-> 컨테이너의 가상 ip와 호스트의 ip를 연결해주는 virtual ethernet bridge 역할을 해준다. 게이트웨이 역할.

L2통신기반

## 2
-p <hostPort>:<containerPort> 옵션을 사용해 외부 노출 가능

## 3
docker0 의 경우 static 네트워크 ip 설정이 불가능해 랜덤으로 생성된다. 새로운 게이트웨이를 생성한다면 static 네트워크 ip 설정이 가능하다.

docker network create --driver bridge \
--subnet 192.168.100.0/24 \
--gateway 192.168.100.254 \
mynet

docker network ls

docker run -d --name appjs \
--net mynet --ip 192.168.100.100 \
-p 8080:8080 \
laegelwinter/appjs

## 4
link 를 사용






