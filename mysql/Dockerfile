# Derived from official mysql image (our base image)
FROM mysql:5.6
# Add a database
ENV MYSQL_DATABASE projectdb
ENV MYSQL_USER test
ENV MYSQL_PASSWORD test
ENV MYSQL_ROOT_PASSWORD sourav
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

