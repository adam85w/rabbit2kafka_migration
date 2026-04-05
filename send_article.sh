curl -i -u guest:guest -H "content-type: application/json" -X POST -d @article.json http://localhost:15672/api/exchanges/%2f/amq.default/publish

