"use client";
import { useEffect, useState } from "react";
import { Button } from "./Button";

export const Contador = () => {
    const [contador, setContador] = useState(0);
    const [coisa, setCoisa] = useState("");

    useEffect(() => {
        console.log("Contador atualizado!");
    }, [contador]);

    useEffect(() => {
        console.log("Coisa atualizado!");
    }, [coisa]);

    useEffect(() => {
        console.log("Contador ou Coisa atualizado!");
    }, [contador, coisa]);

    return <div className="flex flex-col gap-y-2">
        <h2 className="text-xl">Contador</h2>
        <p>Número atual: {contador}</p>
        <div className="flex gap-x-2">
            <Button
                onClick={() => {
                    setContador((c) => c - 3);                
                }}
            >
                -3
            </Button>
            <Button
                onClick={() => {
                    setContador(contador - 1);
                }}
            >
                -1
            </Button>
            <Button
                onClick={() => {
                    setContador(contador + 1);
                }}
            >
                +1
            </Button>
            <Button
                onClick={() => {
                    setContador((c) => c + 3);
                }}
            >
                +3
            </Button>
            
        </div>
        <div className="flex gap-x-2">
            <input className="border border-gray-500 px-4 py-1 rounded"
                value={coisa} onChange={(e) => {
                setCoisa(e.target.value);
            }} />
            <Button
                onClick={() => {
                    setCoisa("");
                }}
            >
                Limpar
            </Button>

        </div>
    </div>
};