# MovieRecommendation
<h2>실행방법</h2>
<p> 1. docker-compose up을 입력해서 실행해주십시오.
<p> 2. Image가 build되고, up되면서 자동으로 db service가 초기화되고,
<p> web service가 자동으로 실행됩니다. 서비스가 완전히 실행될 때까지 느긋하게 기다려주십시오.
<p> 3. docker exec -it movierecommendation_db_1 /bin/bash init.bash을 입력하여
<p> db servive의 초기화를 위해 사용한 sql 파일을 자동으로 삭제합니다.
<p> 4. 이제 평가해주시면 됩니다.
