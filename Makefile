.ONESHELL: # Only applies to all target

install:
	#git clone
	./mvnw clean package -DskipTests
	cp target/betgain-0.0.1-SNAPSHOT.jar src/main/docker/
	cd src/main/docker
	docker-compose up -d --scale tests=0

update:
	#./mvnw clean package -DskipTests
	#cp target/betgain-0.0.1-SNAPSHOT.jar src/main/docker/
	cd src/main/docker/
	docker-compose up --build --force-recreate --no-deps app_api_betgain

infos:
	@printf "API REST : 0.0.0.0:11111 \\n"
	@printf "Interface pgAdmin : 0.0.0.0:5050 \\n"

tests:
	cd src/main/docker/
	docker-compose up --build --force-recreate --no-deps tests