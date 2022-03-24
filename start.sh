export USER="danilo"
export PASSWORD=""
export DATABASE_URL="postgresql://localhost:5432/apirest?createDatabaseIfNotExist=true&sslmode=disable&useTimezone=true&serverTimezone=UTC"
# export DATABASE_URL="mysql://localhost:3306/apirest?createDatabaseIfNotExist=true&sslmode=disable&useTimezone=true&serverTimezone=UTC"
mvn spring-boot:start
