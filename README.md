# MovieRecommendation
<h2>실행방법</h2>
<p> 1. 다음 명령어를 입력해서 미리 docker-compose up에 사용할 이미지 파일을 불러와주십시오.
<p> docker pull wnameless/oracle-xe-11g-r2
<p> docker pull ubuntu:20.04
<p> image가 없어서 발생하는 Fail을 사전에 막기 위함입니다.
<p> 2. docker-compose up을 입력해서 실행해주십시오.
<p> 3. Image가 build되고, up되면서 자동으로 db service가 초기화되고,
<p> web service가 자동으로 실행됩니다. 서비스가 완전히 실행될 때까지 느긋하게 기다려주십시오.
<p> 4. docker exec -it movierecommendation_db_1 /bin/bash init.bash을 입력하여
<p> db servive의 초기화를 위해 사용한 sql 파일을 자동으로 삭제합니다.
<p> 5. 이제 평가해주시면 됩니다.

 ## FrontEnd 접속방법
  - docker-compose up을 통한 서버 실행 및 DB 구동 후 http://localhost:8080/ 접속
