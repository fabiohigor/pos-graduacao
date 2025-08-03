"use client";

import { ContadorContext} from "@/context/ContadorContext";
import { useContext } from "react";
import { Button } from "./Button";


export const ValorContadorGlobal = () => {
    
    const { contador } = useContext(ContadorContext);

    return (
        <div className="flex flex-col gap-y-2">
            <p>Valor do meu Contador Global: {contador}</p>
        </div>
        );    
};