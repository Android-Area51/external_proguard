/*
 * ProGuard -- shrinking, optimization, obfuscation, and preverification
 *             of Java bytecode.
 *
 * Copyright (c) 2002-2009 Eric Lafortune (eric@graphics.cornell.edu)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package proguard.evaluation.value;

/**
 * This class provides methods to create and reuse IntegerValue objects.
 *
 * @author Eric Lafortune
 */
public class SpecificValueFactory
extends      ValueFactory
{
    // Shared copies of Value objects, to avoid creating a lot of objects.
    static final IntegerValue INTEGER_VALUE_M1 = new ParticularIntegerValue(-1);
    static final IntegerValue INTEGER_VALUE_0  = new ParticularIntegerValue(0);
    static final IntegerValue INTEGER_VALUE_1  = new ParticularIntegerValue(1);
    static final IntegerValue INTEGER_VALUE_2  = new ParticularIntegerValue(2);
    static final IntegerValue INTEGER_VALUE_3  = new ParticularIntegerValue(3);
    static final IntegerValue INTEGER_VALUE_4  = new ParticularIntegerValue(4);
    static final IntegerValue INTEGER_VALUE_5  = new ParticularIntegerValue(5);
    static final LongValue    LONG_VALUE_0     = new ParticularLongValue(0);
    static final LongValue    LONG_VALUE_1     = new ParticularLongValue(1);
    static final FloatValue   FLOAT_VALUE_0    = new ParticularFloatValue(0.0f);
    static final FloatValue   FLOAT_VALUE_1    = new ParticularFloatValue(1.0f);
    static final FloatValue   FLOAT_VALUE_2    = new ParticularFloatValue(2.0f);
    static final DoubleValue  DOUBLE_VALUE_0   = new ParticularDoubleValue(0.0);
    static final DoubleValue  DOUBLE_VALUE_1   = new ParticularDoubleValue(1.0);


    // Implementations for ValueFactory.

    public IntegerValue createIntegerValue(int value)
    {
        switch (value)
        {
            case -1: return INTEGER_VALUE_M1;
            case  0: return INTEGER_VALUE_0;
            case  1: return INTEGER_VALUE_1;
            case  2: return INTEGER_VALUE_2;
            case  3: return INTEGER_VALUE_3;
            case  4: return INTEGER_VALUE_4;
            case  5: return INTEGER_VALUE_5;
            default: return new ParticularIntegerValue(value);
        }
    }


    public LongValue createLongValue(long value)
    {
        return value == 0 ? LONG_VALUE_0 :
               value == 1 ? LONG_VALUE_1 :
                            new ParticularLongValue(value);
    }


    public FloatValue createFloatValue(float value)
    {
        return value == 0.0f ? FLOAT_VALUE_0 :
               value == 1.0f ? FLOAT_VALUE_1 :
               value == 2.0f ? FLOAT_VALUE_2 :
                               new ParticularFloatValue(value);
    }


    public DoubleValue createDoubleValue(double value)
    {
        return value == 0.0 ? DOUBLE_VALUE_0 :
               value == 1.0 ? DOUBLE_VALUE_1 :
                              new ParticularDoubleValue(value);
    }
}
