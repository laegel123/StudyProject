
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


