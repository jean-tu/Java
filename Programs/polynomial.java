/*
 Jean Tu
 Polynomial.java
 */

import java.util.*;

class Term
{
    private int coe;
    private int pow;
    public int getCoe()
    {
        return coe;
    }
    public int getPow()
    {
        return pow;
    }
    public void setCoe(int co)
    {
        coe = co;
    }
    public void setPow(int po)
    {
        pow = po;
    }
    public Term (int co, int po)  //Constructor
    {
        coe = co;
        pow = po;
    }
    public String toString()
    {
        return "( "  + coe + ", " + pow + ")";
    }

}

class Polynomial
{
    private LinkedList<Term> poly;
    public Polynomial()
    {
        poly = new LinkedList<Term>();
    }
    public void addTerm(int co, int po)
    {
        Term t = new Term(co,po);
        poly.addLast(t);
    }
    public void print()
    {
        ListIterator<Term>iter = poly.listIterator();
        while (iter.hasNext())
        {
            Term t = iter.next();
            System.out.print(t);
        }
        System.out.println();
    }
    public void insert (int co, int po)
    {
        Term temp = new Term (co, po);
        ListIterator<Term> iter = poly.listIterator();
        while(iter.hasNext())
        {
            Term t = iter.next();
            if (temp.getPow() == t.getPow())
            {
                t.setCoe(temp.getCoe() + t.getCoe());
                return;
            }
            else if(temp.getPow() > t.getPow())
            {
                iter.previous();
                iter.add(temp);
                return;
            }
        }
        iter.add(temp);
    }
    public void add(Polynomial b)
    {
        Polynomial c = new Polynomial();
        ListIterator<Term> iter = poly.listIterator();
        ListIterator<Term> iter1 = b.poly.listIterator();
        while(iter1.hasNext() || iter.hasNext())
        {
            if(iter1.hasNext())
            {
                Term t = iter1.next();
                c.insert(t.getCoe(), t.getPow());
            }
            if(iter.hasNext())
            {
                Term a = iter.next();
                c.insert(a.getCoe(), a.getPow());
            }
        }
        c.print();
    }
    public void multiply(Polynomial b)
    {
        Polynomial c = new Polynomial();
        ListIterator<Term> iter = poly.listIterator();
        ListIterator<Term> iter1 = b.poly.listIterator();

        while (iter.hasNext())
        {
            Term a = iter.next();
            while(iter1.hasNext())
            {
                Term t = iter1.next();
                int coeff = t.getCoe()* a.getCoe();
                int poweff = t.getPow()+ a.getPow();
                c.insert(coeff,poweff);
            }
            while(iter1.hasPrevious())
            {
                iter1.previous();
            }

        }
        c.print();
    }
}

class PolyTest
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Polynomial f = new Polynomial();
        Polynomial s = new Polynomial();
        System.out.print("Enter a Polynomial: ");
        System.out.println("");
        String answer = "yes";
        while(answer.equals("yes"))
        {
            System.out.print("Enter the coefficient of the term you want to add: ");
            int c = in.nextInt();
            System.out.print("Enter the power of the term you want to add: ");
            int po = in.nextInt();
            f.insert(c,po);
            System.out.print("Do you want to add another term? ");
            in.nextLine();
            answer = in.nextLine();
            f.print();
        }
        System.out.print("Insert the second polynomial: ");
        System.out.println("");
        answer = "yes";
        while(answer.equals("yes"))
        {
            System.out.print("Enter the coefficient of the term you want to add: ");
            int c = in.nextInt();
            System.out.print("Enter the power of the term you want to add: ");
            int po = in.nextInt();
            s.insert(c,po);
            System.out.print("Do you want to add another term? ");
            in.nextLine();
            answer = in.nextLine();
            s.print();
        }
        System.out.print("Do you want to multiply the equation? ");
        answer = in.nextLine();
        if(answer.equals("yes"))
        {
            f.multiply(s);
        }
        System.out.print("Do you want to add the polynomials? ");
        answer = in.nextLine();
        if(answer.equals("yes"))
        {
            f.add(s);
        }
    }
}

/*
 Enter a Polynomial:
 Enter the coefficient of the term you want to add: 4
 Enter the power of the term you want to add: 3
 Do you want to add another term? yes
 ( 4, 3)
 Enter the coefficient of the term you want to add: 3
 Enter the power of the term you want to add: 2
 Do you want to add another term? yes
 ( 4, 3)( 3, 2)
 Enter the coefficient of the term you want to add: 1
 Enter the power of the term you want to add: 1
 Do you want to add another term? no
 ( 4, 3)( 3, 2)( 1, 1)
 Insert the second polynomial:
 Enter the coefficient of the term you want to add: 2
 Enter the power of the term you want to add: 4
 Do you want to add another term? yes
 ( 2, 4)
 Enter the coefficient of the term you want to add: 3
 Enter the power of the term you want to add: 3
 Do you want to add another term? no
 ( 2, 4)( 3, 3)
 Do you want to multiply the equation? yes
 ( 8, 7)( 18, 6)( 11, 5)( 3, 4)
 Do you want to add the polynomials? yes
 ( 2, 4)( 7, 3)( 3, 2)( 1, 1)
 Press any key to continue . . .
 */
