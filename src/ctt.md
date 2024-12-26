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

# Synchronization

1. Masalah race condition sebelumnya yang terjadi di Java bisa diselesaikan dengan Synchronization
2. Synchronization merupakan fitur dimana kita memaksa kode program hanya boleh diakses dan dieksekusi oleh satu thread saja
3. Hal ini menyebabkan thread yang lain yang akan mengakses kode program tersebut harus menunggu thread yang lebih dahulu mengakses, sehingga proses Synchronization akan lebih lambat, namun proses Synchronization lebih aman karena tidak akan terjadi race condition

¥ Synchronized Method
1. Di Java, terdapat dua jenis synchronization, yaitu synchronized method dan synchronized statement
2. Synchronized method method merupakan synchronization paling mudah, karena kita hanya perlu menambah kata kunci synchronized pada method yang ingin kita set sebagai synchronization
3. Dengan begitu, secara otomatis method tersebut hanya bisa diakses oleh satu thread pada satu waktu

¥ Intrinsic Lock
1. Synchronization di Java sebenarnya bekerja menggunakan lock
2. Ketika kita melakukan synchronized method, secara otomatis Java akan membuat intrinsic lock atau monitor lock
3. Ketika synchronized method dipanggil oleh thread, thread akan melakukan mencoba mendapatkan intrinsic lock, setelah method selesai (sukses ataupun error), maka thread akan mengembalikan intrinsic lock
4. Semua itu terjadi sejari secara otomatis di synchronized method

¥ Synchronized Statement
1. Saat kita menggunakan synchronized method, secara otomatis seluruh method akan ter synchronization
2. Kadang, misal kita hanya ingin melakukan synchronized pada bagian kode tertentu saja
3. Untuk melakukan hal tersebut, kita bisa menggunakan synchronized statement
4. Namun ketika kita menggunakan synchronized statement, kita harus menentukan object intrinsic lock sendiri


# Deadlock

1. Race condition sangat mudah diselesaikan dengan synchronization dan lock, namun masalah lain bisa mengintai jika kita salah melakukan synchronization, yaitu Deadlock
2. Deadlock merupakan kondisi dimana beberapa thread saling menunggu satu sama lain karena biasanya terjadi ketika thread tersebut melakukan lock dan menunggu lock lain dari thread lain dan ternyata thread tersebut juga menunggu lock lain
3. Karena saling menunggu, akhirnya terjadi deadlock, keadaan dimana semua thread tidak berjalan karena hanya menunggu lock

¥ Cara Menangani Deadlock
1. Sayangnya tidak ada cara menyelesaikan masalah deadlock secara otomatis di Java
2. Masalah deadlock harus diselesaikan sendiri oleh programmer yang membuat kode program nya


# Thread Communication

1. Dalam multithreaded programming, kadang sudah biasa ketika sebuah thread perlu menunggu thread lain menyelesaikan tugas tertentu, baru thread tersebut melakukan tugasnya
2. Sayangnya tidak ada cara otomatis komunikasi antar thread secara langsung
3. Oleh karena itu, programmer harus melakukannya secara manual untuk komunikasi antar thread

¥ Wait dan Notify
1. Menggunakan loop untuk menunggu sangat tidak direkomendasikan, alasannya buang-buang resource CPU dan juga jika terjadi interrupt, loop akan terus berjalan tanpa henti
2. Java sudah menyediakan solusi yang lebih baik dengan menambahkan method wait dan notify di java.lang.Object
3. Artinya kita bisa membuat object apapun menjadi lock, dan gunakan wait() untuk menunggu, dan gunakan notify() untuk memberitahu bahwa data sudah tersedia
4. notify() akan memberi tahu thread lain yang sedang melakukan wait() bahwa proses bisa dilanjutkan


¥ Notify All
1. Kadang ada kasus dimana sebuah lock ditunggu oleh banyak thread, notify() hanya memberi sinyal kepada satu thread saja
2. Jika kita ingin mengirim sinyal ke semua thread, kita bisa menggunakan method notifyAll()

# Timer

1. Timer merupakan class untuk memfasilitasi eksekusi job secara asynchronous di masa depan
2. Timer bisa di schedule untuk berjalan satu kali (delayed job), atau bisa berjalan berulang kali (repeated job)
3. https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Timer.html 


