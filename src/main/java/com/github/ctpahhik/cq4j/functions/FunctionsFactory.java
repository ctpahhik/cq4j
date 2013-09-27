package com.github.ctpahhik.cq4j.functions;

import com.github.ctpahhik.cq4j.common.IInFunction;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.common.ISimpleFunction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class FunctionsFactory {

    private final Map<String, Class<? extends ISimpleFunction>> simpleFunctions = new HashMap<String,  Class<? extends ISimpleFunction>>();
    private final Map<String, Class<? extends IInFunction>> inFunctions = new HashMap<String, Class<? extends IInFunction>>();

    public FunctionsFactory() {
        registerSimpleFunction("nvl", Nvl.class);
        registerSimpleFunction("bitand", BitAnd.class);

        //concat
        //mod

        registerInFunction("position_array", PositionArray.class);
    }

    public void registerSimpleFunction(String name, Class<? extends ISimpleFunction> clazz) {
        simpleFunctions.put(name.toLowerCase(), clazz);
    }

    public void registerInFunction(String name, Class<? extends IInFunction> clazz) {
        inFunctions.put(name.toLowerCase(), clazz);
    }

    public ISimpleFunction createSimpleFunction(String name, List<IOperator> parameters) {
        try {
            Class<? extends ISimpleFunction> clazz = simpleFunctions.get(name.toLowerCase());
            if (AbstractSimpleFunction.class.isAssignableFrom(clazz)) {
                AbstractSimpleFunction function = (AbstractSimpleFunction) clazz.getConstructor().newInstance();
                function.setParameters(parameters);
                return function;
            } else {
                return clazz.getConstructor(List.class).newInstance(parameters);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't create Simple function '" + name + "'", e);
        }
    }

    public IInFunction createInFunction(String name, IOperator valueOp, IOperator inValueOp, IOperator<Integer> fromOp) {
        try {
            Class<? extends IInFunction> clazz = inFunctions.get(name.toLowerCase());
            if (AbstractInFunction.class.isAssignableFrom(clazz)) {
                AbstractInFunction function = (AbstractInFunction) clazz.getConstructor().newInstance();
                function.setParameters(valueOp, inValueOp, fromOp);
                return function;
            } else {
                return clazz.getConstructor(IOperator.class, IOperator.class, IOperator.class).newInstance(valueOp, inValueOp, fromOp);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Can't create In function '" + name + "'", e);
        }
    }
}
