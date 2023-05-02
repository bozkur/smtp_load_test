`src/main/resources/bs_java_mail_sampler.jmx` dosyası içerisinde javamail API kullanan JMeter bean shell sampler'ını içeren test planı var.<br/>
Bu sampler'ı JMeter'da çalıştırabilmek için test planının classpath'ine bu maven modülü ile oluşturulan kütüphaneleri içeren klasörü vermek gerekmekte.
Kütüphaneleri içeren klasörü elde etmek için projeyi aşağıdaki şekilde paketledikten sonra;<br/>
`mvn clean package`<br/>
target içerisinde oluşan `javamail_example-1.0-SNAPSHOT-distribution.zip` dosyasını açmanız yeterli. Oluşan klasörün içerisinde JMeter'ın bean shell'i çalıştırabilmesi için gerekli olan tüm kütüphaneler bulunmakta.

TLDR;
1. `mvn clean package` ile ihtiyaç duyulan kütüphaneleri içeren zip dosyasını oluşturun.
2. target klasörü altında oluşan `javamail_example-1.0-SNAPSHOT-distribution.zip` dosyasını açın.
3. `src/main/resources/bs_java_mail_sampler.jmx` test planını JMeter'da açın.
4. Açılan test planının Library'sine (classpath) 2. adımda oluşturduğunuz jar'ları içeren klasörü ekleyin.
5. Test planınında gerekli değişiklikleri yaparak, testinizi çalıştırın.

JMeter Test Ortamı
* Sunucu: Zimbra Collobration Suite 8.8.15_GA_4522.FOSS
* host: mardin.ccb.org
* domain :mardin.ccb.org
* Hesaplar: testuser<kullanıcı sırası> formatında toplam 200 adet kullanıcı.
