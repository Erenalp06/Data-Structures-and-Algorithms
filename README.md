# Data-Structures-and-Algorithms
Data Structures and Algorithms

## Languages

* Turkish
* English (soon)

# Turkish

## Sıralama Algoritmaları

### 1. Bucket Sort Algoritması

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

 




