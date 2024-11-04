using CoffeeLibrary;

namespace CoffeeShopApp
{
    public class Program
    {
        static void Main(string[] args)
        {
            Barista barista = new Barista();
            barista.StartOrdering();
        }
    }
}