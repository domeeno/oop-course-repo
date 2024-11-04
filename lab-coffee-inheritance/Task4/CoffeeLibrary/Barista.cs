namespace CoffeeLibrary
{
    public class Barista
    {
        public void StartOrdering()
        {
            Console.WriteLine("Welcome to the Coffee Shop!");
            List<Coffee> orders = new List<Coffee>();

            while (true)
            {
                Console.WriteLine("Please select a coffee to order:");
                Console.WriteLine("1. Americano");
                Console.WriteLine("2. Cappuccino");
                Console.WriteLine("3. Pumpkin Spice Latte");
                Console.WriteLine("4. Syrup Cappuccino");
                Console.WriteLine("5. Finish order");

                int choice = int.Parse(Console.ReadLine());

                if (choice == 5)
                {
                    break;
                }

                Coffee coffee = null;

                switch (choice)
                {
                    case 1:
                        coffee = OrderAmericano();
                        break;
                    case 2:
                        coffee = OrderCappuccino();
                        break;
                    case 3:
                        coffee = OrderPumpkinSpiceLatte();
                        break;
                    case 4:
                        coffee = OrderSyrupCappuccino();
                        break;
                    default:
                        Console.WriteLine("Invalid selection. Please try again.");
                        break;
                }

                if (coffee != null)
                {
                    orders.Add(coffee);
                }
            }

            Console.WriteLine("Your order details:");
            foreach (var coffee in orders)
            {
                Console.WriteLine($"\n{coffee.GetType().Name}:");
                coffee.PrintCoffeeDetails(); 
            }

            Console.WriteLine("Thank you for your order!");
        }

        private Americano OrderAmericano()
        {
            Console.WriteLine("Ordering an Americano.");
            Intensity intensity = SelectIntensity();
            int mlOfWater = SelectMlOfWater();

            return Americano.MakeAmericano(intensity, mlOfWater);
        }

        private Cappuccino OrderCappuccino()
        {
            Console.WriteLine("Ordering a Cappuccino.");
            Intensity intensity = SelectIntensity();
            int mlOfMilk = SelectMlOfMilk();

            return Cappuccino.MakeCappuccino(intensity, mlOfMilk);
        }

        private PumpkinSpiceLatte OrderPumpkinSpiceLatte()
        {
            Console.WriteLine("Ordering a Pumpkin Spice Latte.");
            Intensity intensity = SelectIntensity();
            int mlOfMilk = SelectMlOfMilk();
            int mgOfPumpkinSpice = SelectMgOfPumpkinSpice();

            return PumpkinSpiceLatte.MakePumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        }

        private SyrupCappuccino OrderSyrupCappuccino()
        {
            Console.WriteLine("Ordering a Syrup Cappuccino.");
            Intensity intensity = SelectIntensity();
            int mlOfMilk = SelectMlOfMilk();
            SyrupType syrup = SelectSyrup();

            return SyrupCappuccino.MakeSyrupCappuccino(intensity, mlOfMilk, syrup);
        }

        private Intensity SelectIntensity()
        {
            Console.WriteLine("Select intensity:");
            Console.WriteLine("1. LIGHT");
            Console.WriteLine("2. NORMAL");
            Console.WriteLine("3. STRONG");

            int intensityChoice = int.Parse(Console.ReadLine());
            return (Intensity)(intensityChoice - 1);
        }

        private int SelectMlOfWater()
        {
            Console.WriteLine("Select ml of water:");
            Console.WriteLine("1. 50 ml");
            Console.WriteLine("2. 100 ml");
            Console.WriteLine("3. 150 ml");

            int mlChoice = int.Parse(Console.ReadLine());
            return mlChoice switch
            {
                1 => 50,
                2 => 100,
                3 => 150,
                _ => 100
            };
        }

        private int SelectMlOfMilk()
        {
            Console.WriteLine("Select ml of milk:");
            Console.WriteLine("1. 50 ml");
            Console.WriteLine("2. 100 ml");
            Console.WriteLine("3. 150 ml");

            int mlChoice = int.Parse(Console.ReadLine());
            return mlChoice switch
            {
                1 => 50,
                2 => 100,
                3 => 150,
                _ => 100
            };
        }

        private int SelectMgOfPumpkinSpice()
        {
            Console.WriteLine("Select mg of pumpkin spice:");
            Console.WriteLine("1. 10 mg");
            Console.WriteLine("2. 20 mg");
            Console.WriteLine("3. 30 mg");

            int mgChoice = int.Parse(Console.ReadLine());
            return mgChoice switch
            {
                1 => 10,
                2 => 20,
                3 => 30,
                _ => 20
            };
        }

        private SyrupType SelectSyrup()
        {
            Console.WriteLine("Select syrup:");
            foreach (SyrupType syrup in Enum.GetValues(typeof(SyrupType)))
            {
                Console.WriteLine($"{(int)syrup + 1}. {syrup}");
            }

            int syrupChoice = int.Parse(Console.ReadLine());
            return (SyrupType)(syrupChoice - 1);
        }
    }
}
