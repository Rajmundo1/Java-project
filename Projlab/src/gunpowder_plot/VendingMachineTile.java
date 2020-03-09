package gunpowder_plot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**  
 * VendingMachineTile oszt�ly.
 * A Tile �soszt�lyb�l sz�rmazik.
 * Ez az oszt�ly felel�s a csokiautomata reprezent�l�s��rt. 
 */
public class VendingMachineTile extends MachineTile{
	
	/**  
	 * A VendingMachineTile oszt�ly Tick met�dusa. Ez a mez� s�pol� hangot �raszt a szomsz�dos mez�kre.
	 * A s�pol�s meghat�rozott id�k�z�nk�nt t�rt�nik.
	 * @return void
	 */
	public void Tick() {
		boolean random = (new Random().nextInt(20) == 0); // 5%
		boolean willStimulate = random;
		if (willStimulate) {
			List<Animal> occupants = new ArrayList<Animal>();
			
			for(Tile tile : neighbors) {
				Animal o = tile.GetOccupant();
				if(o != null)
					occupants.add(o);
			}
			
			for (Animal o : occupants)
					o.Stimulate(this);
		}
	}
}
