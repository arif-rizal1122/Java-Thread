# PENGENALAN CANCURRANCY

1. Dahulu, komputer hanya menjalankan sebuah program pada satu waktu
2. Karena hanya bisa menjalankan satu program pada satu waktu, hal ini tidak efisien dan memakan waktu lama karena hanya bisa mengerjakan satu tugas pada satu waktu
3. Semakin kesini, sistem operasi untuk komputer semakin berkembang, sekarang sistem operasi bisa menjalankan program secara bersamaan dalam proses yang berbeda-beda, terisolasi dan saling independen antar program

¥ Sejarah Cancurracy
1. Program biasanya berjalan dalam sebuah proses, dan proses akan memiliki resource yang independen dengan proses lain
2. Sekarang, sistem operasi tidak hanya bisa menjalankan multiple proses, namun dalam proses kita bisa menjalankan banyak pekerjaan sekaligus, atau bisa dibilang proses ringan atau lebih dikenal dengan nama Thread
3. Thread membuat proses aplikasi bisa berjalan tidak harus selalu sequential, kita bisa membuat proses aplikasi berjalan menjadi asynchronous atau parallel

¥ Era Multicore
1. Sekarang kita sudah ada di zaman multicore, dimana smartphone pun sudah menggunakan multicore
2. Multicore sangat menguntungkan kita karena bisa membuat aplikasi yang bisa menjalankan proses dan thread secara bersamaan

¥ Cancurrancy VS Pararrel
1. Kadang banyak yang bingung dengan concurrency dan parallel, sebenarnya kita tidak perlu terlalu memusingkan hal ini
2. Karena saat ini, kita pasti akan menggunakan keduanya ketika membuat aplikasi
3. Concurrency artinya mengerjakan beberapa pekerjaan satu persatu pada satu waktu
4. Parallel artiya mengerjakan beberapa pekerjaan sekaligus pada satu waktu

¥ Contoh Concurrency dan Parallel
1. Browser adalah aplikasi yang concurrent dan parallel
2. Browser akan melakukan proses concurrent ketika membuka web, browser akan melakukan http request, lalu mendownload semua file web (html, css, js) lalu merender dalam bentuk tampilan web
3. Browser akan melakukan proses parallel, ketika kita membuka beberapa tab web, dan juga sambil download beberapa file, dan menonton video dari web streaming 

¥ Synchronous vs Asynchronous
1. Saat membuat aplikasi yang concurrent atau parallel, kadang kita sering menemui istilah synchronous dan asynchronous
2. Tidak perlu bingung dengan istilah tersebut, secara sederhana
3. Synchronous adalah ketika kode program kita berjalan secara sequential, dan semua tahapan ditunggu sampai prosesnya selesai baru akan dieksekusi ke tahapan selanjutnya
4. Sedangkan, Asynchronous artinya ketika kode program kita berjalan dan kita tidak perlu menunggu eksekusi kode tersebut selesai, kita bisa lanjutkan ke tahapan kode program selanjutnya
 
¥ 


