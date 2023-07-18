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
   * Dizinin her bir elemanı ile **(arr[i])** dizinin boyutu **(n)** çarpılarak yerleşeceği indis numarası hesaplanır.
   * Örnek olarak: arr[i] = 0.32, n = 7 olsun. **indis = arr[i] * n = 0.32 * 7 = 2.24 = 2** (0.32 > 0 olduğu için pozitif **"kovalar"** dizisinin **"2."** indisine yerleştirilir)
3. Boş olmayan bütün kovalar kendi içinde sıralanır (negatif sıralama reverse yapılmalıdır).
4. Boş olmayan kovalardaki bütün öğeler yeniden diziye yerleştirilir (Önce negatif kovalardakiler daha sonra pozitif kovalardakiler yerleştirilir).


