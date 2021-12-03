# Gittigidiyor.com Test Projesi

Merhaba, test koşumuna ait videoyu izlemek için lütfen [tıklayınız.](https://youtu.be/cJXUGCTivQE)


<img width="960" alt="gittigidiyor" src="https://user-images.githubusercontent.com/26657802/144559367-6d41ef2e-c692-4b57-b5c0-6c19224c7bfc.png">


Proje;
 - Maven
 - Junit 4
 - Selenium
 - Log4j (***Loglama başarıyla yapılıyor, ancak logfile.log dosyasına kaydedil(e)medi. Yalnızca console kısmında log mesajları görünüyor****)

kullanıldı.

# Senaryo Adımları

 - Gittigidiyor Anasayfa aç
 - Login ol (***Login sayfasına link yönlendirme ile gidildi. Maalesef "hover and click" kullanılamadı***)
 - Dilediğin Ürünü Arat ( Bilgisayar aratıldı)
 - Sayfa sonuna scroll yap.
 - Random 4 ürünü sepete ekle (***Random şekilde gerçekleştiremedim, bu sebeple ilk 4 ürünü sepete ekledim.***)
 - Anasayfaya geri dön.
 - "Çanta" ürününü arat.
 -  Listelenen ürünlerden 7. ürünü sepete ekle. (***6.ürünü ekledim. Sebebide şu, test koşumu esnasında herkes aynı ürünü ekleği için üründe stok yok gözüküp, testler patlıyordu. Bu sebeple 6. ürün eklendi. Ancak sadece get(x) metodu içindeki x değeri 7 olarak değiştirilse, 7. ürüne erişim sağlanabilir.***)
 - Sepetime git.
 - Ürün adetini arttır.
 - Ödeme sayfasına geç.
 - "Adres Bilgilerini Kaydet" butonuna tıkla ve hata mesajlarını gör.
 - "Sepeti Düzenle" butonuna tıkla.
 - Favorilerden (sonra alacaklarım) 2. ürünü sepete ekle.
 - Favori ürünlerinden 3. ürünü listeden çıkar.
 - Yeni sekmede anasayfayı(gittigidiyor.com) aç.
 - Çıkış yap. (***Çıkış yapma işlemi link yönlendirme ile yapıldı. Yine "hover and click" kullanılamadı***)
 - Yeni sekmeyi kapat.
 - Tüm penceleri kapat.
 
