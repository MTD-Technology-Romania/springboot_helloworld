# springboot_helloworld


## container(DOCKER) 

 macos(big sur) local storage
```dockerfile
/Users/${user}/Library/Containers/com.docker.docker
```

```dockerfile
DOCKER_BUILDKIT=0 docker build -t user-management -f src/main/docker/Dockerfile . 
```

```dockerfile
DOCKER_BUILDKIT=0  docker build -t user-m -f src/main/docker/Dockerfile --build-arg JAR_FILE=target/*.jar --build-arg PORT=8080 --build-arg DEBUG_PORT=5005  . 
```

```dockerfile
docker-compose down -v && docker-compose up --build --progress=plain
```