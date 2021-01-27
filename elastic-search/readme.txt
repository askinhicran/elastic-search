**Proje initilize edilirken db olarak elastşcSerach secilecek spring.io da. Ondan sonraki adımlar:

1. adım: Resource altına docker-compose.yml dosyası olusturmak.
İçine https://hub.docker.com/_/elasticsearch adresinden elastic search ile ilgili alınması gerekenler yazılacak.

2. adım: Terminali aç ve
docker-compose -f elastic-search/src/main/resources/docker-compose.yml up -d yaz, docker dosyan ayaga arka planda kalksın.(Docker kuruluysa pc ye)
Web browser a localhost:9200 yazınca acılıyor ve belli baglantı ayarları geliyorsa docker ayaga kalkmıstır.

3.adım: 
http://ilkaygunel.com/blog/2020/spring-data-elasticsearch-demo/ buradan once bak.

Entity olustur.ElasticSearch documentBase oldugu için @Document anatosyonunu kullan.ElasticSearch’deki her bir kayda, yani row’a document denir.
DocumentIndexName olarak='kisiler' dedim.Çünkü ElasticSearch’de her kayıt bir Json dökümandır. Yani indexler, Json belgeler topluluğudur.Kısaca her bir index bir çeşit veritabanıdır.
Db de solda tablo gibi kisiler olacak.Onu acınca da column column name,surname,.. olacak.

4.adım KisiReposu olustur interface yap ve ElasticSerachRepo dan extend et.