
interface Swimmer {
    void swim();
}

interface Runner {
    void run();
}


abstract class Animal {
    protected String nama;
    protected int umur;

    public Animal(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    
    abstract void makeSound();

    
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama + ", Umur: " + umur + " tahun");
    }
}


abstract class Mamalia extends Animal {
    protected String jenisBulu;

    public Mamalia(String nama, int umur, String jenisBulu) {
        super(nama, umur); 
        this.jenisBulu = jenisBulu;
    }

    public void menyusui() {
        System.out.println(nama + " sedang menyusui anaknya.");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); 
        System.out.println("Jenis bulu: " + jenisBulu);
    }
}


class Anjing extends Mamalia implements Runner {
    private String ras;

    public Anjing(String nama, int umur, String jenisBulu, String ras) {
        super(nama, umur, jenisBulu);
        this.ras = ras;
    }

    @Override
    void makeSound() {
        System.out.println(nama + " berkata: Guk! Guk!");
    }

    @Override
    public void run() {
        System.out.println(nama + " berlari dengan cepat (Ras: " + ras + ")");
    }
}


class LumbaLumba extends Mamalia implements Swimmer {

    public LumbaLumba(String nama, int umur, String jenisBulu) {
        super(nama, umur, jenisBulu);
    }

    @Override
    void makeSound() {
        System.out.println(nama + " berkata: Klik! Klik!");
    }

    @Override
    public void swim() {
        System.out.println(nama + " berenang dengan lincah di laut.");
    }
}


class Bebek extends Animal implements Swimmer, Runner {

    public Bebek(String nama, int umur) {
        super(nama, umur);
    }

    @Override
    void makeSound() {
        System.out.println(nama + " berkata: Kwek! Kwek!");
    }

    @Override
    public void swim() {
        System.out.println(nama + " berenang di kolam.");
    }

    @Override
    public void run() {
        System.out.println(nama + " berjalan terpincang-pincang di darat.");
    }
}


public class inheritance {
    public static void main(String[] args) {
        Anjing anjing = new Anjing("Rex", 3, "Pendek", "Golden Retriever");
        LumbaLumba lumba = new LumbaLumba("Dolly", 5, "Tidak Berbulu");
        Bebek bebek = new Bebek("Donald", 1);

        
        Animal[] animals = { anjing, lumba, bebek };

        for (Animal a : animals) {
            System.out.println("----------------------------");
            a.tampilkanInfo();
            a.makeSound();

            
            if (a instanceof Swimmer) {
                ((Swimmer) a).swim();
            }
            if (a instanceof Runner) {
                ((Runner) a).run();
            }
            if (a instanceof Mamalia) {
                ((Mamalia) a).menyusui();
            }
        }
    }
}