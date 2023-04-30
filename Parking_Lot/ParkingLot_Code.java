//add admin
class Vehicle
{
	int regNum;
	VehicleType vType;

}
public enum VehicleType
{
    TWO, FOUR, HEAVY;
}
class ParkingSpace
{
	int spaceId;
	int floorId;
	Vehicle vehicle;
	int price;
	boolean isEmpty; 
	//make this class abstract
	
	public void parkVehicle(Vehicle v)
	{
		isEmpty= false;
		vehicle= v;	
	}
	public void removeVehicle()
	{
		vehicle= null;
		isEmpty= True;
	}
}
class TwoWheelerSpace extends ParkingSpace
{
	int price= 10;
}
class FourWheelerSpace extends ParkingSpace
{
	int price= 20;
}
class HeavyVehicleSpace extends ParkingSpace
{
	int price= 40;
}
class Floor
{
	int floorId;
    boolean isEmpty;
	List<ParkingSpace> pSpaces;
	public void addParkingSpace(ParkingSpace p){}
	public void removeParkingSpace(ParkingSpace p){}
}

class PakingSpaceFactory
{
    ParkingSpace pSpace;
	public ParkingSpace getParkingSpace(Vehicle v)
	{
		//return object of TwoWheelerSpace or FourWheeler based on VehicleType
	}
}
class ParkingLot
{
	List<Floor> floorList; //initialized in constructor
	ParkingSpaceFactory pSpaceFact;
	//parking strategy object
	//add gate manager
	//make it singleton class- pubic class, private constructor, initialize inside class 
	//public static ParkingLot INSTANCE= new ParkingLot()
	//private ParkingLot()
	// {
	// 	floorList= new ArrayList<> ();

	// }
	//every other class is public class & public constructor
	//checking for free space before getting parkingspot	 canPark()
	//add gate, remove gate
	//canpark(), park(), vacate() by calling same functions in floor
	
	
	public void addFloor(Floor f, List<ParkingSpace> p){}
	public void removeFloor(Floor f){}
	public ParkingSpace findParkingSpace(EntryGate entry, Vehicle v)
	{
		//Parking space found on the basis of type of vehicle using ParkingSpace Factory class
		//Parking space is found close to entry gate
		//add parking strategy
	}
}
class GateManager
{
	List<EntryGate> entries;
	List<ExitGate> exits;
	
	public void addEntryGate(EntryGate entry){}
	public void removeEntryGate(EntryGate entry){}
	public void addExitGate(ExitGate exit){}
	public void removeExitGate(ExitGate exit){}
	
}
class EntryGate 
{
	int gateid;
	ParkingLot pLot;
	//check for free space before finding space
	//do everything inside getticket()- checking space and all
	
    public Vehicle getVehicle(Vehicle v){}
	public ParkingSpace findSpace(){
        //uses object of parkingLot to find Space
    } 
	public void updateParkingSpace(ParkingSpace pSpace){}
	public Ticket generateTicket(){}
}
class Ticket
{
	int ticketId;
    Date today;
	Time entryTime;
    Time exitTime;
	Vehicle v;
	ParkingSpace pSpace;
	//isactive
	//charges - function for this


    public void getExitTime(Time time){}
	
}
class PaymentInfo
{
	int transactionId;
	double amount;
    Date date;
	Ticket ticket;
	PaymentType pType;
	PaymentStrategy pStrategy;


}
public enum PaymentType
{
    CASH, CARD, UPI;
}
class ExitGate
{
	int gateId;
	Ticket t;
	
    
	public double calculatePrice(PaymentStrategy pStrategy)
	{
		return pStrategy* calculateCost();
	}
	public PaymentInfo generatePaymentInfo(PaymentType pType){}
	public void freeParkingSpace(){}
}
class PaymentStrategy
{
	public double calculateCost(){}
	
}
class HourlyPaymentStrategy extends PaymentStrategy
{
	public double calculateCost(Ticket t)
	{
		double parkedTime=(Currenttime- t.entryTime); // convert to hours
		return parkedTime * t.pSpace.price; 
    }
}
class MinutesPaymentStrategy extends PaymentStrategy
{
	public double calculateCost(Ticket t)
	{
		double parkedTime=(Currenttime- t.entryTime); // convert to minutes
		return parkedTime * t.pSpace.price; 
    }
}