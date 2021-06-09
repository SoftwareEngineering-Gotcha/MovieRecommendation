<h1> db_1 image 초기 설정 방법 </h1>

1. docker-compose up 으로 실행

2. 처음 실행 시 db_1 image에서 자동으로 data initialization 작업을 시작

3. 마지막에 SQL> Disconnected from Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production 문구가 나올 때 까지 대기

4. docker exec -it movierecommendation_db_1 /bin/bash init.bash 로 초기화