# Getting Started
1. Use `docker-compose up -d` to start the containers
2. Tail the logs on the `spark` container with `docker-compose logs -f spark`
3. Attach to `nc` container with `docker attach nc` and start typing input, you
   should see the spark container running the python script processing this
   input
