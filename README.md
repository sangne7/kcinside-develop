# kcinside-devleop
kcinside project develop

나를 위한 실행법 정리

1. ssh ec2 접속
2. git clone
3. properites file 생성 (db connection)
4. build
   4-1. 폴더 권한 설정 $chmod 777 ./gradlew
   4-2. 빌드 $./gradle bootjar
   4-3. 실행 $nohup java -jar build/libs/project.jar & (백그라운드 실행)
   4-4. 로그 nohup.out
   4-.5 종료 sudo kill -9 {PID}
