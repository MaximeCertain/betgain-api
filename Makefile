.ONESHELL: # Only applies to all target

install:
	cd src/main/docker
	docker-compose up -d db_api_betgain pgadmin_api_betgain app_api_betgain

update:
	cd src/main/docker/
	docker-compose up --build --force-recreate --no-deps app_api_betgain

infos:
	@printf "API REST : 0.0.0.0:11111 \\n"
	@printf "Interface pgAdmin : 0.0.0.0:5050 \\n"

tests:
	cd src/main/docker/
	docker-compose up --build --force-recreate --no-deps tests

dev:
	./mvnw clean package -DskipTests
	cp target/betgain-0.0.1-SNAPSHOT.jar src/main/docker/
	cd src/main/docker
	docker-compose up --build --force-recreate --no-deps app_dev_betgain
