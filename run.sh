./create_network.sh &
(cd confluent && podman-compose up -d) &
(cd rabbit && podman-compose up -d) &
