# Data-Structures-and-Algorithms
Data Structures and Algorithms

## Languages

* Turkish
* English (soon)

# Turkish

## Sıralama Algoritmaları

### 1. Bucket Sort Algoritması

* [Bucket Sort Nedir ve Nasıl Çalışır](#bucket-sort-nedir-ve-nasıl-çalışır)
* [JAVA ile Algoritma Implementasyonu](#java-ile-algoritma-implementasyonu)
* [Test Senaryoları](#test-senaryoları)
* [Karmaşıklık Analizi](#karmaşıklık-analizi)

### Bucket Sort Nedir ve Nasıl Çalışır ###

**Kova Sıralaması** (ya da **sepet sıralaması**), sıralanacak bir diziyi parçalara ayırarak sınırlı sayıdaki kovalara (ya da sepetlere) atan bir sıralama algoritmasıdır. Ayrıştırma işleminden sonra her kova kendi içinde
ya farklı bir sıralama algoritması kullanılarak ya da kova sıralamasını özyinelemeli bir şekilde çağırarak sıralanır.

Kova sıralaması adımları şunlardır (Input olarak float dizisi varsayılmıştır):

1. Başlangıçta boş olan pozitif veya negatif sayılara göre iki adet **"kovalar"** dizisi oluşturulur.
2. Asıl dizinin üzerinden geçerek her bir elemanın **"kovalar"** dizilerinde yerleştirileceği indisler hesaplanır.
   * Dizinin her bir elemanından **(arr[i])** minimum değer **(min)** çıkartılır ve dizinin boyutunun 1 eksiği ile **(n - 1)** çarpılır, bulunan değer **(max - min)** değerine bölünür.
   * Yukarıda yapılan işlem dizideki sayıların sınırlı sayıdaki kovalara yerleştirilmesini sağlar, aksi taktirde büyük sayılarda **IndexOutOfBound** hatası verecektir.
   * Örnek olarak:
       * arr[0] = 3.2, n = 6, max = 3.2, min = -4.8 kabul edelim
       * **indis = (arr[0] - min) * (arr.length - 1) / (max - min) = (3.2 - (-4.8)) * (6 - 1) / (3.2 - (-4.8)) = 5** (3.2 > 0 olduğu için pozitif **"kovalar"** dizisinin **"5."** indisine yerleştirilir)
3. Boş olmayan bütün kovalar kendi içinde sıralanır.
4. Boş olmayan kovalardaki bütün öğeler yeniden diziye yerleştirilir (Önce negatif kovalardakiler daha sonra pozitif kovalardakiler yerleştirilir).

#### Adım 1
Başlangıçta boş olan pozitif veya negatif sayılara göre iki adet **"kovalar"** dizisi oluşturulur.

<img src="/images/bucketsort/1.png" alt="Adım 1" width="750">



#### Adım 2
Asıl dizinin üzerinden geçerek her bir elemanın **"kovalar"** dizilerinde yerleştirileceği indisler hesaplanır.

<img src="/images/bucketsort/2.0.png" alt="Adım 2" width="750">

#### Adım 2 Sonu

<img src="/images/bucketsort/2.1.png" alt="Adım 2 Son" width="750">

#### Adım 3
Boş olmayan bütün kovalar kendi içinde sıralanır. Burada kovalardaki elemanlar sıralı olduğu için ek bir sıralamaya ihtiyaç duyulmadı.

<img src="/images/bucketsort/3.png" alt="Adım 3" width="750">



#### Adım 4 (Son)
 Boş olmayan kovalardaki bütün öğeler yeniden diziye yerleştirilir (Önce negatif kovalardakiler daha sonra pozitif kovalardakiler yerleştirilir).

<img src="/images/bucketsort/4.png" alt="Adım 4" width="750">



 ### JAVA ile Algoritma Implementasyonu ###

 ```java
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    static void sort(float[] arr) {
        if (arr.length <= 0) {
            return;
        }
  
        float max = arr[0];
        float min = arr[0];

        // Max ve Min değerleri hesapla
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Pozitif ve Negaitfler için iki adet kovalar dizisi oluştur.
        ArrayList<Float>[] negativeBuckets = new ArrayList[arr.length];
        ArrayList<Float>[] positiveBuckets = new ArrayList[arr.length];

        for (int i = 0; i < arr.length; i++) {
            negativeBuckets[i] = new ArrayList<>();
            positiveBuckets[i] = new ArrayList<>();
        }

        // Dizinin her bir elemanının hangi indise yerleştirileceğini hesapla
        for (int i = 0; i < arr.length; i++) {
            int index;
            if (arr[i] >= 0) {
                index = (int) ((arr[i] - min) * (arr.length - 1) / (max - min));
                positiveBuckets[index].add(arr[i]);
            } else {
                index = (int) Math.abs(((arr[i] - min) * (arr.length - 1) / (max - min)));
                negativeBuckets[index].add(arr[i]);
            }
        }

        // Her bir kovayı kendi içinde sırala
        for (int i = 0; i < arr.length; i++) {
            Collections.sort(positiveBuckets[i]);
            Collections.sort(negativeBuckets[i]);
        }

        // Önce negatif daha sonra pozitif kovalardaki elemanları tek tek diziye yaz
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < negativeBuckets[i].size(); j++) {
                arr[index++] = negativeBuckets[i].get(j);

            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < positiveBuckets[i].size(); j++) {
                arr[index++] = positiveBuckets[i].get(j);
            }
        }
    }
}
```


 ### Test Senaryoları ###



1. Senaryo : Pozitif Sayılar
```bash
float[] arr = {0.5f, 0.2f, 0.8f, 0.1f, 0.9f, 0.3f};
```
* Çıktı
```bash
Sorted data : [0.1, 0.2, 0.3, 0.5, 0.8, 0.9]
```

***

2. Senaryo : Negatif Sayılar
```bash
float[] arr = {-0.5f, -0.2f, -0.8f, -0.1f, -0.9f, -0.3f};
```
* Çıktı
```bash
Sorted data : [-0.9, -0.8, -0.5, -0.3, -0.2, -0.1]
```

***

3. Senaryo : Pozitif ve Negatif Sayılar
```bash
float[] arr = {-0.5f, 0.2f, -0.8f, 0.1f, -0.9f, 0.3f};
```
* Çıktı
```bash
Sorted data : [-0.9, -0.8, -0.5, 0.1, 0.2, 0.3]
```

***

4. Senaryo : Tekrarlayan Sayılar
```bash
float[] arr = {0.5f, 0.2f, 0.8f, 0.2f, 0.9f, 0.5f};
```
* Çıktı
```bash
Sorted data : [0.2, 0.2, 0.5, 0.5, 0.8, 0.9]
```

***

5. Senaryo : Boş Dizi
```bash
float[] arr = {};
```
* Çıktı
```bash
Sorted data : []
```

***

6. Senaryo : Tek Elemanlı Dizi
```bash
float[] arr = {0.5f};
```
* Çıktı
```bash
Sorted data : [0.5]
```

 ### Karmaşıklık Analizi ###

**1. Zaman Karmaşıklığı (Time Complexity)**

  * En iyi Durum (Best Case) -> Veri seti düzgün aralıkla dağılmışsa, her aralık sadece bir eleman içerir ve sıralama işlemine ihtiyaç duyulmaz. Bu durumda, aralıkların sayısı n'ye eşit olur ve tüm elemanlar doğrudan yerine yerleştirilir. Bu nedenle, zaman karmaşıklığı O(n) olur, çünkü tüm elemanlar tek geçişte sıralanır.

  * Ortalama Durum (Avarage Case) -> Eğer elemanlar düzensiz bir şekilde aralıklara dağılırsa, yani bazı aralıklar boş kalırken, bazı aralıklar çok sayıda eleman içerebilir. Bu durumda, her bir aralıkta birden fazla eleman bulunur ve bu elemanlar arasındaki sıralama için ekstra sıralama algoritmaları kullanılır. Bu ekstra sıralama işlemi, her bir aralıktaki eleman sayısına bağlı olarak zaman alabilir. Bu nedenle, toplam zaman karmaşıklığı O(n+k) olacaktır. Burada **'k'** aralıkların sayısıdır.

  * En kötü Durum (Worst Case) -> Tüm elemanlar tek bir aralığa düşerse, tüm öğeleri içeren yalnızca tek bir kova oluşacaktır. Bu kovadaki elemanları da Insertion Sort veya Selection sort ile sıralarsak, Insertion Sort'un en kötü durum zaman karmaşıklığı O(n^2) olduğu düşünülürse, toplamda O(n^2) zaman karmaşıklığı olacaktır.

**2. Uzay Karmaşıklığı (Space Complexity)**

  * Yukarıdaki algoritma için, her bir elemanın bir kovaya yerleştirildiği varsayılırsa, kova sayısı, gelen dizi boyutu ile aynı olduğundan uzay karmaşıklığı O(n) olacaktır. Burada **'n'** dizi boyutudur ve kova sayısıdır.


 ### Kullanım Alanları ###

 1. Sıralama Algoritmalarının Parçaları Olarak: Özellikle çeşitli sıralama algoritmalarında küçük aralıklara veya alt dizilere bölme işleminde **Kova Sıralaması** kullanılabilir.
 2. Histogram Oluşturma: **Kova Sıralaması**, histogram oluşturmak için kullanılabilir. Örneğin, bir resimdeki renk dağılımını analiz etmek veya metin içindeki harflerin frekansını hesaplamak gibi durumlarda kullanılabilir.
 3. Nümerik Analiz: Sayısal analiz ve veri bilimi alanında, büyük veri kümesini belli aralıklara bölmek ve bu aralıkların özet istatistiklerini hesaplamak için kullanılabilir.
 4. Harf Sıralama: Harflerden oluşan bir metni sıralamak için kullanılabilir. Özellikle isim veya kelime listelerini alfabeik sıraya göre düzenlemek için kullanışlıdır.
 5. Sayıdal Veri Sıralama: Büyük sayısal veri kümesini sıralamak için diğer sıralama algoritmaları gibi Bucket Sort da kullanılabilir.



 






