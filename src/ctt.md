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
 

# Thread

1. Di Java, implementasi Concurrency dan Parallel dapat menggunakan Thread
2. Thread direpresentasikan oleh class bernama Thread di package java.lang

¥ Thread Utama
1. Secara default, saat sebuah aplikasi Java berjalan, minimal akan ada satu thread yang berjalan
2. Dalam aplikasi Java biasa, biasanya kode program kita akan berjalan di dalam thread yang bernama main
3. Bahkan di Unit Test pun, memiliki thread sendiri

¥ Membuat Thread
1. Thread merupakan proses ringan, membuat Thread bukan berarti kita melakukan pekerjaan
2. Untuk membuat pekerjaan, kita perlu membuat object dari interface Runnable, selanjutnya object Runnable tersebut bisa kita berikan ke Thread untuk dijalankan
3. Saat Thread berjalan, dia akan berjalan secara asynchronous, artinya dia akan berjalan sendiri, dan kode program kita akan berlanjut ke kode program selanjutnya
4. Untuk menjalankan Thread, kita bisa memanggil function start() milik Thread

¥ Thread Sleep
1. Pada saat proses development, kada kita butuh melakukan simulasi proses yang berjalan dalam waktu tertentu
2. Untuk melakukan hal ini, kita bisa memanfaatkan fitur Thread Sleep yang terdapat di Java
3. Dengan menggunakan Thread Sleep, kita bisa membuat sebuah thread tertidur dan berhenti dalam waktu yang kita tentukan
4. Untuk melakukan hal ini, kita bisa memanggil static method sleep() di class Thread, maka secara otomatis Thread saat itu dimana memanggil kode sleep() akan tertidur sesuai dengan waktu milisecond yang sudah kita masukkan dalam parameter
5. Namun perlu diperhatikan, method sleep bisa menyebabkan error InterruptedException


¥ Thread Join
1. Kadang kita ingin menunggu sampai sebuah thread selesai tugasnya
2. Untuk melakukan hal tersebut, kita bisa memanggil method join milik thread yang akan kita tunggu

¥ Thread Interrupt
1. Interrupt merupakan mengirim sinyal ke thread bahwa thread tersebut harus berhenti melakukan pekerjaannya saat ini
2. Untuk melakukan interrupt, kita bisa menggunakan method interrupt() pada thread
3. Saat kita memanggil method interrupt(), secara otomatis Thread.interrupted() akan bernilai true
4. Perlu diingat, kode program kita pada Runnable harus melakukan pengecekan interrupted, jika tidak, sinyal interrupt tidak ada gunanya

¥ Thread Name
1. Secara default thread di Java memiliki nama, ini sangat cocok untuk proses debugging ketika terjadi masalah
2. Thread name secara default akan menggunakan nama Thread-{counter}
3. Namun kita juga bisa mengubahnya dengan menggunakan method setName(name), dan getName() untuk mendapatkan nama thread nya

¥ Thread State
1. Thread di Java memiliki state, state yaitu informasi state sebuah thread
2. State digunakan hanya untuk mendapat informasi
3. State akan berubah statusnya sesuai dengan apa yang terjadi di thread
4. Untuk mendapatkan data state, kita bisa menggunakan method getState() dan akan mengembalikan enum State

¥ Thread Daemon
1. Secara default, saat kita membuat thread, thread tersebut disebut user thread
2. Java (bukan JUnit) secara default akan selalu menunggu semua user thread selesai sebelum program berhenti
3. Jika kita mengubah thread menjadi daemon thread, menggunakan setDaemon(true), maka secara otomatis thread tersebut menjadi daemon thread
4. Daemon thread tidak akan ditunggu jika memang program Java akan berhenti
5. Namun jika kita menghentikan program Java menggunakan System.exit(), maka user thread pun akan otomatis terhenti

# Race Condition

1. Salah satu problem yang sering sekali terjadi dalam aplikasi concurrent dan parallel adalah race condition
2. Race condition merupakan keadaan ketika sebuah data diubah secara berbarengan oleh beberapa thread yang menyebabkan hasil akhir yang tidak sesuai dengan yang kita inginkan

