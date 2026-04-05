# RabbitMQ Migration to Confluent Platform

This project provides a **minimal and straightforward solution** for migrating a RabbitMQ queue to a Kafka topic within the Confluent Platform ecosystem.

The migration leverages a **connector**, a **JSON-to-object transformation**, and an **Avro converter**.

The final result is a **Kafka topic** and a **schema** in the **Schema Registry** in Avro format.

This solution is **fully ready-to-use** and requires **zero custom code** during migration.
No additional supporting structures (queues or topics) are created either in RabbitMQ or in Confluent Platform.

![Migration Diagram](/assets/migration_diagram.svg)

# Running PoC
## Running RabbitMQ and Confluent Platform

To run this example, you need **Podman** and **podman-compose**.  
Alternatively, you can use **Docker** and **docker-compose**.

Even though separate compose files are used, both systems are connected via a shared network.

You can start all containers using the following script:

```shell
./run.sh
```

The script creates the network and starts both environments.

Web Interfaces 
- **Confluent Control Center**: http://localhost:9021/
- **RabbitMQ Management**: http://localhost:15672 (guest/guest)


## Configuring the Queue, Connector and Running the Example

First, you need to create a queue in RabbitMQ. In a real system, this queue would already exist, as it would be the queue being migrated.  
The easiest way is to open the management panel and create a new queue, as shown in the screenshot below.

![RabbitMQ queue](/assets/rabbitmq_queue.png)

Next, go to Confluent Control Center and import the connector using the configuration from the `articles_connector_config.json` file.

![Adding RabbitMQ Source Connector](/assets/adding_connector.png)

![RabbitMQ Source Connector](/assets/connector.png)

You can send a message to the queue using the provided script.
```shell
./send_article.sh
```

After sending the first message, a Kafka topic should be created automatically along with the registered schema.

![Topic Schema](/assets/topic_schema.png)

You can consume the message using the sample Java application located in the `spring_consumer` directory.

![Spring APP](/assets/spring_app.png)

## Tools Used

- **Confluent Platform**: https://docs.confluent.io/platform/current/overview.html
- **RabbitMQ**: https://www.rabbitmq.com/
- **RabbitMQ Connector**: https://www.confluent.io/hub/confluentinc/kafka-connect-rabbitmq
- **JSON Schema Connector**: https://www.confluent.io/hub/jcustenborder/kafka-connect-json-schema
- **podman / podman-compose**
- **curl**
- **Java / Spring Boot**

# Credits & Licenses
This example is intended solely as a demonstration of the Confluent Platform's capabilities for migrating RabbitMQ queues.

To use it in a real-world scenario, appropriate licenses must be obtained — in particular, licenses for the Confluent Platform components.

# Author
Adam Woźniak <adam85.w@gmail.com>