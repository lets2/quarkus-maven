# quarkus-maven project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-maven-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-maven-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-maven-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

# SWAGGER - OPENAPI

```
http://localhost:8080/swagger-ui
```

Guide: https://quarkus.io/guides/rest-json

# Build image from Dockerfile.jvm

```shell script
./mvnw package or mvn clean package
```

```shell script
docker build -f src/main/docker/Dockerfile.jvm -t lets2/quarkus-maven-jvm:latest .
```

# Executar um container a partir da imagem

```shell script
docker run -i --rm -p 8080:8080 lets2/quarkus-maven-jvm:latest
```

# Caso deseje debug mode, modificar o **Dockerfile.jvm** para **EXPOSE 8080 5050** e aplique

```shell script
docker run -i --rm -p 8080:8080 -p 5005:5005 -e JAVA_ENABLE_DEBUG="true" lets2/quarkus-maven-jvm:1.0.0
```

# Registrar no Dockerhub

```shell script
docker login
docker push lets2/quarkus-maven-jvm:1.0.0
docker push lets2/quarkus-maven-jvm:latest
```

# Baixar a imagem

```shell script
docker pull lets2/quarkus-maven-jvm:1.0.0
```

# Remover imagens sem tag

```shell script
docker rmi $(docker images --filter "dangling=true" -q --no-trunc)
```

# Fazer deployment usando manifests do kubernetes

```bash
minikube start
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
```

# Pegue o internal IP a partir do nodes ex: 192.168.1.2

```bash
kubectl get nodes -o wide
```

# Pegue o IP do node usando o service ex: PORT 80:31840/TCP use 31840

```bash
kubectl get service
```

# Acessar a aplicação:

```bash
http://192.168.1.2:31840
```
