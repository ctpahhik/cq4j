package com.github.ctpahhik.cq4j.common;

import com.github.ctpahhik.cq4j.functions.BitAnd;
import com.github.ctpahhik.cq4j.functions.Nvl;
import com.github.ctpahhik.cq4j.functions.PositionArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: JavaDoc
 *
 * @author Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class FunctionsFactory {

    private final Map<String, ISimpleFunction> simpleFunctionPrototypes = new HashMap<String, ISimpleFunction>();
    private final Map<String, IInFunction> inFunctionPrototypes = new HashMap<String, IInFunction>();

    public FunctionsFactory() {
        registerSimpleFunction(new Nvl());
        registerSimpleFunction(new BitAnd());

        //concat
        //mod
        //case

        registerInFunction(new PositionArray());
    }

    public void registerSimpleFunction(ISimpleFunction function) {
        simpleFunctionPrototypes.put(function.getName().toLowerCase(), function);
    }

    public void registerSimpleFunction(String name, ISimpleFunction function) {
        simpleFunctionPrototypes.put(name.toLowerCase(), function);
    }

    public void registerInFunction(IInFunction function) {
        inFunctionPrototypes.put(function.getName().toLowerCase(), function);
    }

    public void registerInFunction(String name, IInFunction function) {
        inFunctionPrototypes.put(name.toLowerCase(), function);
    }

    public ISimpleFunction createSimpleFunction(String name, List<IOperator> parameters) {
        return simpleFunctionPrototypes.get(name.toLowerCase()).create(parameters);
    }

    public IInFunction createInFunction(String name, IOperator valueOp, IOperator inValueOp, IOperator<Integer> fromOp) {
        return inFunctionPrototypes.get(name.toLowerCase()).create(valueOp, inValueOp, fromOp);
    }
}
