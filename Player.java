import WeaponFil.Weapon;
import EnemyFil.Enemy;
//Player navn og hp
public class Player {
 
public int hp;
public Weapon currentWeapon;
public Enemy currentFiend;
public String navn;

public void setName(String newName){

    navn = newName;

}

public String getName(){

    return navn;

}



}
